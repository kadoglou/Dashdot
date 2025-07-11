package com.kitos14.dashdot

import android.app.Application
import com.kitos14.dashdot.di.initKoin
import org.koin.android.ext.koin.androidContext

class InitializeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@InitializeApp)
        }
    }

}