package com.grupounoptresunal.kamaleon

import android.app.Application
import com.grupounoptresunal.kamaleon.di.dataSourceModule
import com.grupounoptresunal.kamaleon.di.repoModule
import com.grupounoptresunal.kamaleon.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataSourceModule, repoModule, viewModelModule))
        }
    }
}