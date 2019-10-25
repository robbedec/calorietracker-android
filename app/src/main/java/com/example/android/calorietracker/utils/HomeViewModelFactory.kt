package com.example.android.calorietracker.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val dataSource: EatingDayDao, private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}