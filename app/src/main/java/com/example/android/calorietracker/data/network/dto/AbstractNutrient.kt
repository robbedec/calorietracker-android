package com.example.android.calorietracker.data.network.dto

import com.squareup.moshi.Json

data class AbstractNutrient(
    @Json(name = "attr_id") val id: Int,
    val value: Double
)