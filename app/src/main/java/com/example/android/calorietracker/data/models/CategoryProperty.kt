package com.example.android.calorietracker.data.models

/**
 * Class that holds the different categories of [FoodProperty].
 *
 * Can contain branded, common and self.
 * More information about the API response is provided in the README.
 *
 * @property branded a list of properties retrieved from the 'branded' array in the response.
 * @constructor Creates a [CategoryProperty] with empty properties.
 *
 * @author Robbe Decorte
 */
data class CategoryProperty (
    val branded: List<FoodProperty>
)