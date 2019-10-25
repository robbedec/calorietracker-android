package com.example.android.calorietracker.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class EatingDayWithEntries (

    @Embedded
    var eatingDay: EatingDay? = null,

    @Relation(parentColumn = "dayId", entityColumn = "ownerId")
    var entries: List<FoodEntry> = ArrayList()
)