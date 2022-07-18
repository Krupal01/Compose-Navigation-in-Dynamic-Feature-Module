package com.example.navigationinfeaturemodule

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}