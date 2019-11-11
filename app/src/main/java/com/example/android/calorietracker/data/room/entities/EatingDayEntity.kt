package com.example.android.calorietracker.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.calorietracker.domain.EatingDay
import com.example.android.calorietracker.utils.DateConverter
import java.util.*

/**
 * Represents a single day that can be stored and retrieved from the Room database.
 *
 * @property dayId the unique identifier.
 * @property date the date when the entity was created.
 * @property amountCal the amount of calories that the user has registered.
 * @property limitCal number of calories that the user wants to eat in a day.
 * @constructor Creates an [EatingDayEntity] with default properties or with the details provided in the constructor.
 *
 * @author Robbe Decorte
 */
@Entity(tableName = "daily_eating_table")
@TypeConverters(DateConverter::class)
data class EatingDayEntity(

    @PrimaryKey(autoGenerate = true)
    var dayId: Long = 0L,

    @ColumnInfo(name = "start_date")
    var date: Date = Calendar.getInstance().time,

    @ColumnInfo(name = "amount_calories")
    val amountCal: Int = 0,

    @ColumnInfo(name = "limit_calories")
    val limitCal: Int = 5000
)

/**
 * Extension method to convert a [FoodEntryEntity].
 *
 * @return a [EatindDay].
 */
fun EatingDayEntity.asDomainModel(): EatingDay {
    return EatingDay(
        id = dayId,
        date = date,
        amountCal = amountCal,
        limitCal = limitCal)
}
