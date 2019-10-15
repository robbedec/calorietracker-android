package com.example.android.calorietracker

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {
    // A base class that contains global application state for the entire app

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        Timber.plant(Timber.DebugTree())
    }
}