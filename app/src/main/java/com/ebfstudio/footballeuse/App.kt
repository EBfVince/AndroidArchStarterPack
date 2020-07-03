package com.ebfstudio.footballeuse

import android.app.Application
import com.ebfstudio.footballeuse.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
@Suppress("unused")
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

    private fun provideComponent() = appComponent

}