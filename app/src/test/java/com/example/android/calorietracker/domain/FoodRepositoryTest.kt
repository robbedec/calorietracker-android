package com.example.android.calorietracker.domain

import android.net.ConnectivityManager
import com.example.android.calorietracker.data.network.CalorieTrackerApiService
import com.example.android.calorietracker.data.room.CalorieDatabase
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test

class FoodRepositoryTest {
    private lateinit var repository: FoodRepository
    private val database = mockk<CalorieDatabase>()
    private val apiService = mockk<CalorieTrackerApiService>()

    @Before
    fun setUp() {
        repository = FoodRepository(database, apiService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

}