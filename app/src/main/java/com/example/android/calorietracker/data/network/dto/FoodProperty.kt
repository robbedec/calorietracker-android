package com.example.android.calorietracker.data.network.dto

import com.example.android.calorietracker.data.room.entities.FoodEntry
import com.squareup.moshi.Json

/**
 * Holds 1 category that can be retrieved from the API.
 *
 * @property id the unique identifier.
 * @property name the display name of the property.
 * @property amountCal the amount of calories in the property.
 *
 * @author Robbe Decorte
 */

data class FoodProperty (
    @Json(name = "nix_item_id") val id: String,
    @Json(name= "food_name") val name: String,
    @Json(name = "brand_name") val brandName: String,
    @Json(name = "nf_calories") val amountCal: Double,
    @Json(name = "photo") val image: Photo,
    @Json(name = "full_nutrients") var nutrients: List<AbstractNutrient>,
    @Json(name = "serving_weight_grams") private val _weight: Double? = 0.0

) {
    val weight: Double = _weight ?: 0.0
}
