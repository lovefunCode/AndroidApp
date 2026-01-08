# React Native Code Directory

This folder contains all React Native related code and configuration.

## Directory Structure

```
react-native/
├── src/              # React Native source code
│   ├── App.js       # Root component
│   └── index.js     # Entry file
├── app.json         # React Native app configuration
├── package.json      # Node.js dependencies configuration
├── metro.config.js   # Metro bundler configuration
├── .babelrc         # Babel transpilation configuration
└── node_modules/     # Node.js dependencies (generated after running npm install)
```

## Development Workflow

### Start Metro Server

Run in the `react-native/` directory:

```bash
cd react-native
npm start
```

### Run Android Application

Run in the project root directory:

```bash
npm run android
```

Or:

```bash
cd react-native
npm run android
```

## Important Notes

- React Native source code is in the `src/` directory
- Metro server needs to be started in the `react-native/` directory
- Android native code is in the `app/` directory at the project root
