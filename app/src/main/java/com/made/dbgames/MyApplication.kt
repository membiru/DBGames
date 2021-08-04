package com.made.dbgames

import android.app.Application
import com.made.dbgames.core.di.databaseModule
import com.made.dbgames.core.di.networkModule
import com.made.dbgames.core.di.repositoryModule
import com.made.dbgames.di.useCaseModule
import com.made.dbgames.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}