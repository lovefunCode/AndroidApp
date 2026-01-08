# Quick Start Guide

## 5-Minute Quick Start to Run React Native App

### Step 1: Install Dependencies

```bash
# Execute in the project root directory
npm install
```

### Step 2: Start Metro Bundler

Open a new terminal window and run in the project root directory:

```bash
npm start
```

Keep this terminal window open, as the Metro server needs to keep running.

### Step 3: Run Android App

#### Option A: Using Android Studio
1. Open Android Studio
2. Open the project directory
3. Wait for Gradle sync to complete
4. Connect an Android device or start an emulator
5. Click the green Run button

#### Option B: Using Command Line
```bash
# In the project root directory (another terminal window)
./gradlew installDebug
```

### Step 4: Verify

After the app launches, you should see:
- ✅ React Native interface
- ✅ Counter functionality
- ✅ Learning points

## Important Notes

### Component Name Must Match

Ensure the names match exactly in these three places:

1. **app.json**:
```json
{
  "name": "MyFirstApp"
}
```

2. **MainActivity.kt**:
```kotlin
override fun getMainComponentName(): String {
    return "MyFirstApp"
}
```

3. **index.js**:
```javascript
AppRegistry.registerComponent(appName, () => App);
// appName comes from app.json
```

### Development Mode

- **Modify React Native Code**: Edit `App.js`, save and shake device to select "Reload"
- **Modify Android Code**: Rebuild and run in Android Studio

### Common Issues

**Issue**: App shows "Unable to connect to Metro"
- **Solution**: Ensure `npm start` is running and device/emulator can access the development machine

**Issue**: Component not found
- **Solution**: Check that component name matches in all three places (see above)

**Issue**: Build fails
- **Solution**: Run `./gradlew clean` then rebuild

## Next Steps

Check `README.md` for more detailed information and learning resources.
