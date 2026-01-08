package com.example.myapplication

import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

/**
 * MainActivity
 * 这是应用的主 Activity，用于加载和显示 React Native 组件
 * 
 * 关键点：
 * 1. 继承自 ReactActivity 而不是普通的 Activity
 * 2. getMainComponentName() 返回的组件名必须与 index.js 中注册的组件名一致
 * 3. 组件名来自 app.json 中的 "name" 字段
 */
class MainActivity : ReactActivity() {

    /**
     * 返回 React Native 主组件的名称
     * 这个名称必须与 index.js 中 AppRegistry.registerComponent 注册的名称一致
     * 也就是 app.json 中的 "name" 字段值
     */
    override fun getMainComponentName(): String {
        return "MyFirstApp" // 必须与 app.json 中的 "name" 字段匹配
    }

    /**
     * 创建 ReactActivityDelegate
     * 这个方法用于配置 React Native 的加载方式
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate {
        return DefaultReactActivityDelegate(
            this,
            mainComponentName,
            fabricEnabled
        )
    }
}