package com.example.android.calorietracker.utils

import androidx.room.TypeConverter
import java.util.*

/**
 * Convert java.util.date to Long so it can be stored in the database.
 *
 * In the future it might be interesting to implement an [alternative](www.github.com/JakeWharton/ThreeTenABP).
 *
 * @author Robbe Decorte
 */
class DateConverter {

    /**
     * Convert [Long] to [Date].
     *
     * @param dateLong that is converted to a date.
     * @return date based on the parameter.
     */
    @TypeConverter
    fun toDate(dateLong: Long): Date? {
        return Date(dateLong)
    }

    /**
     * Convert [Date] to [Long].
     *
     * @param date that is converted to a long.
     * @return long based on the parameter.
     */
    @TypeConverter
    fun fromDate(date: Date): Long? {
        return date.time
    }
}