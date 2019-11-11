package com.example.android.calorietracker.domain

import java.util.*

data class EatingDay (
    var id: Long,
    var date: Date,
    var amountCal: Int,
    var limitCal: Int
)