package com.test.app

import android.app.Application
import com.test.app.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() = startKoin {
        androidContext(this@App)
        modules(provideComponent())
    }

    // PUBLIC API ---
    open fun provideComponent() = appComponent

}