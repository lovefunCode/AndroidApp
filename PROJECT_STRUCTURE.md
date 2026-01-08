# 项目结构说明

## 新的项目结构

```
AndroidApp/
├── app/                          # Android 原生代码
│   ├── src/main/
│   │   ├── java/...              # Kotlin/Java 源代码
│   │   ├── res/                  # Android 资源文件
│   │   └── AndroidManifest.xml   # Android 清单文件
│   └── build.gradle.kts          # Android 模块构建配置
│
├── react-native/                 # React Native 代码（独立文件夹）
│   ├── src/                      # React Native 源代码
│   │   ├── App.js               # 根组件
│   │   └── index.js             # 入口文件
│   ├── app.json                 # React Native 应用配置
│   ├── package.json              # Node.js 依赖配置
│   ├── metro.config.js           # Metro 打包器配置
│   ├── .babelrc                  # Babel 转译配置
│   ├── node_modules/             # Node.js 依赖（运行 npm install 后生成）
│   └── README.md                 # React Native 目录说明
│
├── build.gradle.kts              # 项目级 Gradle 配置
├── settings.gradle.kts           # Gradle 设置
├── gradle.properties             # Gradle 属性
└── (其他 Android 项目配置文件)
```

## 关键点

### 1. 代码分离
- **Android 原生代码**：在 `app/` 目录下
- **React Native 代码**：在 `react-native/` 目录下
- 两者完全分离，便于维护

### 2. 开发流程

#### 启动 Metro 服务器
```bash
cd react-native
npm install  # 首次运行需要安装依赖
npm start
```

#### 运行 Android 应用
在项目根目录：
```bash
./gradlew installDebug
```

或者在 Android Studio 中直接运行。

### 3. 路径配置

- **MainApplication.kt**: `getJSMainModuleName()` 返回 `"src/index"`（相对于 react-native/ 目录）
- **Metro 配置**: `projectRoot` 指向 `react-native/` 目录
- **package.json**: 位于 `react-native/` 目录

## 迁移步骤

如果你是从旧结构迁移过来的：

1. ✅ React Native 源代码已移动到 `react-native/src/`
2. ✅ React Native 配置文件已移动到 `react-native/`
3. ✅ MainApplication.kt 已更新路径
4. ⚠️ **需要手动操作**：
   - 删除根目录的旧文件（App.js, index.js, app.json, package.json, metro.config.js, .babelrc）
   - 在 `react-native/` 目录下运行 `npm install` 安装依赖
   - 删除根目录的 `node_modules/`（如果存在）

## 优势

1. **清晰的代码组织**：Android 和 React Native 代码完全分离
2. **易于维护**：每个部分都有独立的配置和依赖
3. **符合最佳实践**：遵循 React Native 集成到现有项目的推荐结构

