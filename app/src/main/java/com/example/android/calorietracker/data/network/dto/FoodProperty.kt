package com.example.android.calorietracker.data.network.dto

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
    @Json(name = "nf_calories") val amountCal: Double
)