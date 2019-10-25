package com.example.android.calorietracker.utils

import androidx.room.TypeConverter
import java.util.*

/*
 * Convert java.util.date to Long
 * This can be stored in the database
 *
 * TODO: alternative @ www.github.com/JakeWharton/ThreeTenABP
 */
class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long): Date? {
        return if(dateLong == null) {
            null
        } else {
            Date(dateLong)
        }
    }

    @TypeConverter
    fun fromDate(date: Date): Long? {
        return date?.time
    }
}