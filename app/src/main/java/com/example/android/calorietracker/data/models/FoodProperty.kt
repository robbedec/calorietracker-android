package com.example.android.calorietracker.data.models

import com.squareup.moshi.Json

data class FoodProperty (
    @Json(name= "food_name") val name: String,
    @Json(name = "nf_calories") val amountCal: Double
)