# React Native 代码目录

这个文件夹包含所有 React Native 相关的代码和配置。

## 目录结构

```
react-native/
├── src/              # React Native 源代码
│   ├── App.js       # 根组件
│   └── index.js     # 入口文件
├── app.json         # React Native 应用配置
├── package.json      # Node.js 依赖配置
├── metro.config.js   # Metro 打包器配置
├── .babelrc         # Babel 转译配置
└── node_modules/     # Node.js 依赖（运行 npm install 后生成）
```

## 开发流程

### 启动 Metro 服务器

在 `react-native/` 目录下运行：

```bash
cd react-native
npm start
```

### 运行 Android 应用

在项目根目录运行：

```bash
npm run android
```

或者：

```bash
cd react-native
npm run android
```

## 重要提示

- React Native 源代码在 `src/` 目录下
- Metro 服务器需要在 `react-native/` 目录下启动
- Android 原生代码在项目根目录的 `app/` 目录下

