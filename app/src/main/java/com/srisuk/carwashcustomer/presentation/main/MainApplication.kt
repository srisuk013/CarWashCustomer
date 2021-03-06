package com.srisuk.carwashcustomer.presentation.main

import android.app.Application
import com.srisuk.carwashcustomer.di.appModule
import com.srisuk.carwashcustomer.model.request.BookingJobRequest
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            koin.loadModules(listOf(appModule))
            koin.createRootScope()
        }
    }
}
