package com.example.android.calorietracker.utils

import com.example.android.calorietracker.data.network.dto.FoodProperty
import com.example.android.calorietracker.data.room.entities.FoodEntry

fun formatAmount(amount: Int): Int {
    return amount
}

fun formatGoal(goal: Int): Int {
    return goal
}


fun FoodProperty.asDatabaseEntity(): FoodEntry {
    return FoodEntry(
        entryName = name,
        entryCalories = amountCal.toInt(),
        apiId = id,
        brandName = brandName,
        image = image.thumb,
        imageBig = image.highres,
        weight = weight
    )
}
