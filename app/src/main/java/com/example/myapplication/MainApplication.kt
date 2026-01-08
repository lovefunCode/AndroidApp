package com.example.myapplication

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

/**
 * MainApplication
 * 这是 React Native 应用的主 Application 类
 * 它负责初始化 React Native 环境
 */
class MainApplication : Application(), ReactApplication {

    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {
            /**
             * 手动注册 React Native 核心包
             * MainReactPackage 包含了所有核心模块（AppState, ImageLoader, WebSocketModule 等）
             */
            override fun getPackages(): List<ReactPackage> =
                listOf(
                    MainReactPackage() // 注册所有核心 React Native 模块
                    // 在这里可以添加自定义的原生模块
                )

            // React Native 入口文件在 react-native/index.js
            // Metro 在 react-native/ 目录下运行，所以入口文件路径是 "index"
            override fun getJSMainModuleName(): String = "index"

            // 开发阶段直接开启开发者支持
            override fun getUseDeveloperSupport(): Boolean = true

            override val isNewArchEnabled: Boolean = false
            override val isHermesEnabled: Boolean = true
        }

    override val reactHost: ReactHost
        get() = getDefaultReactHost(applicationContext, reactNativeHost)

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }
}

