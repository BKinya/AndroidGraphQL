package com.beatrice.androidgraphql

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.DEBUG)
    }
}