# Project Structure Documentation

## New Project Structure

```
AndroidApp/
├── app/                          # Android native code
│   ├── src/main/
│   │   ├── java/...              # Kotlin/Java source code
│   │   ├── res/                  # Android resource files
│   │   └── AndroidManifest.xml   # Android manifest file
│   └── build.gradle.kts          # Android module build configuration
│
├── react-native/                 # React Native code (separate folder)
│   ├── src/                      # React Native source code
│   │   ├── App.js               # Root component
│   │   └── index.js             # Entry file
│   ├── app.json                 # React Native app configuration
│   ├── package.json              # Node.js dependencies configuration
│   ├── metro.config.js           # Metro bundler configuration
│   ├── .babelrc                  # Babel transpilation configuration
│   ├── node_modules/             # Node.js dependencies (generated after running npm install)
│   └── README.md                 # React Native directory documentation
│
├── build.gradle.kts              # Project-level Gradle configuration
├── settings.gradle.kts           # Gradle settings
├── gradle.properties             # Gradle properties
└── (Other Android project configuration files)
```

## Key Points

### 1. Code Separation
- **Android native code**: Located in the `app/` directory
- **React Native code**: Located in the `react-native/` directory
- Both are completely separated for easier maintenance

### 2. Development Workflow

#### Start Metro Server
```bash
cd react-native
npm install  # Install dependencies on first run
npm start
```

#### Run Android Application
In the project root directory:
```bash
./gradlew installDebug
```

Or run directly in Android Studio.

### 3. Path Configuration

- **MainApplication.kt**: `getJSMainModuleName()` returns `"src/index"` (relative to react-native/ directory)
- **Metro configuration**: `projectRoot` points to the `react-native/` directory
- **package.json**: Located in the `react-native/` directory

## Migration Steps

If you are migrating from the old structure:

1. ✅ React Native source code has been moved to `react-native/src/`
2. ✅ React Native configuration files have been moved to `react-native/`
3. ✅ MainApplication.kt has been updated with new paths
4. ⚠️ **Manual action required**:
   - Delete old files in the root directory (App.js, index.js, app.json, package.json, metro.config.js, .babelrc)
   - Run `npm install` in the `react-native/` directory to install dependencies
   - Delete the `node_modules/` directory in the root (if it exists)

## Advantages

1. **Clear code organization**: Android and React Native code are completely separated
2. **Easy maintenance**: Each part has independent configuration and dependencies
3. **Follows best practices**: Adheres to recommended structure for integrating React Native into existing projects
