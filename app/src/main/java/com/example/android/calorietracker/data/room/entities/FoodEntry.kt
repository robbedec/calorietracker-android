package com.example.android.calorietracker.data.room.entities

import androidx.room.*

/**
 * Represents a [FoodEntry] that can be retrieved or pulled from the Room database.
 *
 * @property entryId the unique identifier.
 * @property entryName the display name of the entry.
 * @property entryCalories the amount of calories in the entry.
 * @property ownerId foreign key that points to the id of [EatingDay] that it belongs to.
 * @property apiId key to get information about the entry from the online API, defaults to an empty string.
 * @constructor Creates an [FoodEntry] with default properties or with the details provided in the constructor.
 *
 * More information about foreign keys can be found [here](www.medium.com/@tonyowen/room-entity-annotations-379150e1ca82)
 *
 * @author Robbe Decorte
 */
@Entity(tableName = "food_entry_table")
data class FoodEntry (

    @PrimaryKey(autoGenerate = true)
    var entryId: Long = 0L,

    @ColumnInfo(name = "food_name")
    var entryName: String = "name",

    @ColumnInfo(name = "food_amount_calories")
    var entryCalories: Int = 0,

    var ownerId: Long = 0L,

    var apiId: String = ""

)