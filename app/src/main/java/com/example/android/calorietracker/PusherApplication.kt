package com.example.android.calorietracker

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import timber.log.Timber

/**
 *  A base class that holds application wide logic.
 *
 *  @author Robbe Decorte
 */
class PusherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        Timber.plant(Timber.DebugTree())

        // Make applicationContext accessible as a static variable.
        context = applicationContext
    }
}