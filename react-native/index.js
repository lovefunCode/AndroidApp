/**
 * @format
 * React Native 入口文件
 * 这个文件位于 react-native/ 根目录，用于 Metro 打包器
 * Metro 默认在项目根目录寻找 index.js
 */

import {AppRegistry} from 'react-native';
import App from './src/App';
import {name as appName} from './app.json';

// 注意：appName 必须与 app.json 中的 "name" 字段匹配

AppRegistry.registerComponent(appName, () => App);

