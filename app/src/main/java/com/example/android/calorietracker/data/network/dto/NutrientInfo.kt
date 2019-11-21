package com.example.android.calorietracker.data.network.dto

import com.squareup.moshi.Json

data class NutrientInfo(
    val attr_id: Int,
    @Json(name = "usda_nutr_desc") val _name: String? = "t",
    val unit: String
) {
    val name = _name ?: "t"
}