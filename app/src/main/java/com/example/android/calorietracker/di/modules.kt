package com.example.android.calorietracker.di

import com.example.android.calorietracker.data.network.CalorieTrackerApi
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.domain.FoodRepository
import org.koin.dsl.module

val mainModule = module {
    single { CalorieDatabase.getInstance(get()) }

    single { CalorieTrackerApi.retrofitService }

    single { FoodRepository(get(), get()) }
}