# App Shell Architecture Guide

## What is App Shell?

App Shell is a hybrid application architecture pattern where:
- **Android Native Code** = Shell (the container)
- **React Native** = Content (the content)

This architecture allows you to use React Native to develop UI and business logic while maintaining the native application infrastructure.

## Architecture Diagram

```
┌─────────────────────────────────────────┐
│         Android Application            │
│  ┌───────────────────────────────────┐  │
│  │      MainApplication.kt           │  │
│  │  (Initialize React Native env)   │  │
│  └───────────────────────────────────┘  │
│              │                           │
│              ▼                           │
│  ┌───────────────────────────────────┐  │
│  │      MainActivity.kt               │  │
│  │  (ReactActivity - Load RN Component)│  │
│  └───────────────────────────────────┘  │
│              │                           │
│              ▼                           │
│  ┌───────────────────────────────────┐  │
│  │   React Native Bridge (JS Bridge) │  │
│  │   (JavaScript ↔ Native Communication)│  │
│  └───────────────────────────────────┘  │
│              │                           │
│              ▼                           │
│  ┌───────────────────────────────────┐  │
│  │      React Native (JavaScript)    │  │
│  │  ┌─────────────────────────────┐  │  │
│  │  │      index.js               │  │  │
│  │  │  (Entry file, register component)│  │
│  │  └─────────────────────────────┘  │  │
│  │              │                     │  │
│  │              ▼                     │  │
│  │  ┌─────────────────────────────┐  │  │
│  │  │      App.js                 │  │  │
│  │  │  (Root component, UI & logic)│  │  │
│  │  └─────────────────────────────┘  │  │
│  └───────────────────────────────────┘  │
└─────────────────────────────────────────┘
```

## Key Components Explained

### 1. MainApplication.kt

**Purpose**: Application entry point that initializes the React Native environment

**Key Responsibilities**:
- Implements `ReactApplication` interface
- Creates `ReactNativeHost` instance
- Configures React Native package list
- Initializes SoLoader (for loading native libraries)

**Code Structure**:
```kotlin
class MainApplication : Application(), ReactApplication {
    override val reactNativeHost: ReactNativeHost = ...
    override val reactHost: ReactHost = ...
    override fun onCreate() { ... }
}
```

### 2. MainActivity.kt

**Purpose**: Activity that displays React Native components

**Key Responsibilities**:
- Extends `ReactActivity` (not a regular Activity)
- Returns the component name to load (`getMainComponentName()`)
- Configures how React Native is loaded

**Key Method**:
```kotlin
override fun getMainComponentName(): String {
    return "MyFirstApp"  // Must match "name" in app.json
}
```

### 3. index.js

**Purpose**: React Native entry file

**Key Responsibilities**:
- Imports root component (App.js)
- Reads application name from app.json
- Registers component using `AppRegistry.registerComponent`

**Code Structure**:
```javascript
import App from './App';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => App);
```

### 4. App.js

**Purpose**: React Native root component

**Key Responsibilities**:
- Defines application UI
- Handles business logic
- Manages component state

## Data Flow

### Startup Flow

1. **Android System Launches App**
   - Creates `MainApplication` instance
   - Calls `onCreate()`, initializes React Native environment

2. **Launch MainActivity**
   - `MainActivity` extends `ReactActivity`
   - Calls `getMainComponentName()` to get component name

3. **Load React Native**
   - React Native bridge connects to Metro server (development mode)
   - Or loads bundled JavaScript bundle (production mode)

4. **Execute JavaScript**
   - Executes `index.js`
   - Registers component and creates root component instance
   - Renders UI from `App.js`

### Communication Flow

```
React Native (JS)  ←→  JavaScript Bridge  ←→  Android Native (Kotlin/Java)
```

- **JS → Native**: Through Native Modules
- **Native → JS**: Through Events or Callbacks

## Configuration Points

### 1. Component Name Matching (Most Important!)

Three places must match exactly:

| Location | Value | Description |
|----------|-------|-------------|
| `app.json` | `"name": "MyFirstApp"` | React Native app name |
| `MainActivity.kt` | `return "MyFirstApp"` | Returned component name |
| `index.js` | `appName` (from app.json) | Registered component name |

### 2. AndroidManifest.xml

Must configure:
- `android:name=".MainApplication"` - Specify Application class
- `INTERNET` permission - Connect to Metro server
- `configChanges` - Handle configuration changes

### 3. build.gradle.kts

Must add:
- React Native dependencies
- SoLoader dependency
- NDK configuration
- Packaging configuration (exclude conflicting files)

## Development Mode vs Production Mode

### Development Mode

- Metro server runs on development machine
- JavaScript code loaded dynamically from Metro server
- Supports Hot Reload
- Shows Red Screen of Death for errors

**Run**: `npm start` + Run Android app

### Production Mode

- JavaScript code bundled into APK
- No dependency on Metro server
- Code optimized and minified
- Friendlier error handling

**Build**: `./gradlew assembleRelease`

## Advantages

1. **Progressive Adoption**: Can gradually migrate native code to React Native
2. **Performance**: Native code handles performance-critical parts
3. **Flexibility**: Can mix native and React Native code
4. **Development Efficiency**: React Native provides rapid iteration capabilities

## Limitations

1. **Complexity**: Need to maintain two codebases (native + React Native)
2. **Bundle Size**: App size increases (includes React Native runtime)
3. **Debugging**: Need to debug both native and JavaScript code

## Learning Path

1. ✅ **Basic Integration** - Current stage: Get React Native running in Android
2. 🔄 **Native Modules** - Create custom native modules to communicate with React Native
3. 🔄 **Navigation** - Integrate React Navigation
4. 🔄 **State Management** - Add Redux or Context API
5. 🔄 **Performance Optimization** - Optimize rendering and memory usage

## Reference Resources

- [React Native Official Documentation](https://reactnative.dev/)
- [Integration with Existing Apps](https://reactnative.dev/docs/integration-with-existing-apps)
- [Native Modules](https://reactnative.dev/docs/native-modules-android)
