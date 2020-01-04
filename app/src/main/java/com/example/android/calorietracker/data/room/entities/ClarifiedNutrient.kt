package com.example.android.calorietracker.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClarifiedNutrient(

    @PrimaryKey(autoGenerate = true)
    val nutId: Long = 0L,

    val name: String = "",

    val value: Double = 0.0,

    val unit: String = "",

    val parentId: Long = 0L
)