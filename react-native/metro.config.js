const path = require('path');
const {getDefaultConfig, mergeConfig} = require('@react-native/metro-config');

/**
 * Metro configuration
 * https://facebook.github.io/metro/docs/configuration
 *
 * @type {import('metro-config').MetroConfig}
 */
const config = {
  server: {
    port: 9000,
  },
  // 配置项目根目录为 react-native 文件夹
  projectRoot: __dirname,
  // 不监控整个父目录，只监控 react-native 目录，避免文件描述符耗尽
  // watchFolders: [
  //   path.resolve(__dirname, '..'),
  // ],
  // 配置 resolver 的源扩展名
  resolver: {
    sourceExts: ['jsx', 'js', 'ts', 'tsx', 'json'],
  },
  // 使用轮询模式作为备选（如果 Watchman 不可用）
  watchFolders: [],
};

module.exports = mergeConfig(getDefaultConfig(__dirname), config);

