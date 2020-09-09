package com.srisuk.carwashcustomer

import android.app.Application
import com.srisuk.carwashcustomer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext( this@MainApplication)
            koin.loadModules(listOf(appModule))
            koin.createRootScope()
        }
    }
}