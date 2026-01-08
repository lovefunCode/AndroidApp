# React Native Integration into Android Project

This project demonstrates how to integrate React Native into an existing Android native project, implementing the App Shell architecture.

## Project Structure

```
AndroidApp/
├── app/                          # Android native application module
│   └── src/main/
│       ├── java/com/example/myapplication/
│       │   ├── MainActivity.kt   # Main Activity, loads React Native
│       │   └── MainApplication.kt # Application class, initializes React Native
│       └── AndroidManifest.xml   # Android manifest file
├── App.js                        # React Native root component
├── index.js                      # React Native entry file
├── app.json                      # React Native app configuration
├── package.json                  # Node.js dependencies configuration
├── metro.config.js               # Metro bundler configuration
└── .babelrc                      # Babel transpilation configuration
```

## Core Concepts

### 1. App Shell Architecture

App Shell is an architecture pattern where:
- **Android Native Code** acts as the "Shell" (container), responsible for application infrastructure
- **React Native** acts as the "Content", responsible for UI and business logic
- Both communicate through JavaScript Bridge

### 2. Key Components

#### MainApplication.kt
- Extends `Application` and implements `ReactApplication`
- Initializes React Native environment
- Configures React Native Host and package list

#### MainActivity.kt
- Extends `ReactActivity` (not a regular Activity)
- The component name returned by `getMainComponentName()` must match the name registered in `index.js`
- Component name comes from the `"name"` field in `app.json`

#### index.js
- React Native entry file
- Uses `AppRegistry.registerComponent` to register root component
- Component name must match the value returned by `MainActivity.getMainComponentName()`

#### App.js
- React Native root component
- Contains all UI and business logic

## Installation and Running

### Prerequisites

1. **Node.js** (version >= 18)
2. **npm** or **yarn**
3. **Android Studio** and Android SDK
4. **Java Development Kit (JDK)** 11 or higher

### Step 1: Install Node.js Dependencies

Run in the project root directory:

```bash
npm install
# or
yarn install
```

### Step 2: Start Metro Bundler

Metro is React Native's JavaScript bundler. Run in the project root directory:

```bash
npm start
# or
yarn start
```

This will start the Metro server at `http://localhost:8081`.

### Step 3: Build and Run Android App

#### Method 1: Using Android Studio
1. Open Android Studio
2. Open the project directory
3. Wait for Gradle sync to complete
4. Connect an Android device or start an emulator
5. Click the Run button

#### Method 2: Using Command Line

```bash
# In the project root directory
./gradlew installDebug

# Or using React Native CLI
npm run android
```

### Step 4: Verify Running

After the app launches, you should see:
- React Native interface (from `App.js`)
- A counter example
- Some learning points

## Development Workflow

### Modifying React Native Code

1. Edit `App.js` or other React Native files
2. Save the file
3. Press `R` key twice on the device (or shake the device) to reload
4. Or press `r` key after running `npm start` to reload

### Modifying Android Native Code

1. Edit Kotlin/Java files
2. Click "Sync Project with Gradle Files" in Android Studio
3. Rebuild and run the app

### Debugging

#### React Native Debugging
- Shake the device and select "Debug"
- Or press `Ctrl+M` (Windows/Linux) or `Cmd+M` (Mac)
- Open developer tools in Chrome

#### Android Native Debugging
- Use Android Studio's debugger
- View Logcat output

## Key Configuration Notes

### app.json
```json
{
  "name": "MyFirstApp",  // This name must match MainActivity.getMainComponentName()
  "displayName": "My First App"
}
```

### MainActivity.kt
```kotlin
override fun getMainComponentName(): String {
    return "MyFirstApp"  // Must match "name" in app.json
}
```

### index.js
```javascript
AppRegistry.registerComponent(appName, () => App);
// appName comes from the "name" field in app.json
```

## Common Issues

### 1. Metro Server Connection Failed

**Issue**: App cannot connect to Metro bundler

**Solution**:
- Ensure Metro server is running (`npm start`)
- Check that device/emulator and development machine are on the same network
- For physical devices, ensure using the correct IP address (configure in `MainApplication.kt`)

### 2. Component Name Mismatch

**Issue**: App shows "Component not found" on startup

**Solution**:
- Ensure the `"name"` in `app.json` exactly matches the value returned by `MainActivity.getMainComponentName()`
- Ensure the component name registered in `index.js` also matches

### 3. Build Errors

**Issue**: Gradle build fails

**Solution**:
- Clean the project: `./gradlew clean`
- Delete `node_modules` and reinstall: `rm -rf node_modules && npm install`
- Click "Sync Project with Gradle Files" in Android Studio

### 4. Dependency Version Conflicts

**Issue**: React Native version incompatible with Android dependencies

**Solution**:
- Ensure React Native version matches Android dependency versions
- Check [React Native Official Documentation](https://reactnative.dev/docs/environment-setup) for compatible version information

## Learning Resources

- [React Native Official Documentation](https://reactnative.dev/)
- [React Native Architecture](https://reactnative.dev/docs/architecture-overview)
- [Android Integration Guide](https://reactnative.dev/docs/integration-with-existing-apps)

## Next Steps

1. **Add More React Native Components**: Add more features in `App.js`
2. **Native Modules**: Create custom native modules to communicate with React Native
3. **Navigation**: Integrate React Navigation for page navigation
4. **State Management**: Add Redux or Context API for state management

## License

This project is for learning purposes only.
