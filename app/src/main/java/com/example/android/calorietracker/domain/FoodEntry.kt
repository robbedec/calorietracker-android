package com.example.android.calorietracker.domain

data class FoodEntry (
    var id: Long,
    var name: String,
    var calories: Int,
    var ownerId: Long,
    var apiId: String = ""
)
