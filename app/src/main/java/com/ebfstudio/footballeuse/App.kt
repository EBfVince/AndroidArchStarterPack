package com.ebfstudio.footballeuse

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() = startKoin {
        androidLogger()
        androidContext(this@App)
        modules(provideComponent())
    }

    private fun provideComponent() = emptyList<Module>() // appComponent(setupServer())

}