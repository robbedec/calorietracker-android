package com.example.android.calorietracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_entry_table")
data class FoodEntry (

    @PrimaryKey(autoGenerate = true)
    var entryId: Long = 0L,

    @ColumnInfo(name = "food_name")
    val entryName: String = "name",

    @ColumnInfo(name = "food_amount_calories")
    val entryCalories: Int = 0
)