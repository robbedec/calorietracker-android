package com.example.android.calorietracker

import android.app.Application
import timber.log.Timber

/**
 *  A base class that holds application wide logic.
 *
 *  @author Robbe Decorte
 */
class PusherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        Timber.plant(Timber.DebugTree())
    }
}