package com.example.android.calorietracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.calorietracker.utils.DateConverter
import java.util.*

@Entity(tableName = "daily_eating_table")
@TypeConverters(DateConverter::class)
data class EatingDay(

    @PrimaryKey(autoGenerate = true)
    var dayId: Long = 0L,

    @ColumnInfo(name = "start_date")
    var date: Date = Calendar.getInstance().time,

    @ColumnInfo(name = "amount_calories")
    val amountCal: Int = 0,

    @ColumnInfo(name = "limit_calories")
    val limitCal: Int = 5000
)
