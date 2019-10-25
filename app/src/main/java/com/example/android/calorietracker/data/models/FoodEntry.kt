package com.example.android.calorietracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/*
 * More information about foreign keys @ www.medium.com/@tonyowen/room-entity-annotations-379150e1ca82
 */

@Entity(
    tableName = "food_entry_table"/*,
    foreignKeys = arrayOf(ForeignKey(entity = EatingDay::class,
        parentColumns = arrayOf("dayId"),
        childColumns = arrayOf("ownerId"),
        onDelete = ForeignKey.CASCADE))*/)
data class FoodEntry (

    @PrimaryKey(autoGenerate = true)
    var entryId: Long = 0L,

    @ColumnInfo(name = "food_name")
    val entryName: String = "name",

    @ColumnInfo(name = "food_amount_calories")
    val entryCalories: Int = 0,

    val ownerId: Long = 0L
)