package com.example.android.calorietracker

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.android.calorietracker.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


/**
 *  A base class that holds application wide logic.
 *
 *  @author Robbe Decorte
 */
class PusherApplication : Application() {

    companion object {
        lateinit var appId: String
        lateinit var appKey: String
    }

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        Timber.plant(Timber.DebugTree())

        // Make apiKeys accessible as a static variable.
        appId = applicationContext.getString(R.string.x_app_id)
        appKey = applicationContext.getString(R.string.x_app_key)

        // Setup koin
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@PusherApplication)
            modules(mainModule)
        }
    }
}