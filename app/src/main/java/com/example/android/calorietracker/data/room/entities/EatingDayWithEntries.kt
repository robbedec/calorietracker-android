package com.example.android.calorietracker.data.room.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Database entity that embeds an [EatingDay] with the entries from that day.
 *
 * @property eatingDay the [EatingDay] object.
 * @property entries a [List] of [FoodEntry] from the embedded [EatingDay].
 * @constructor Creates an [EatingDayWithEntries] with default properties or with the properties provided in the constructor.
 *
 * @author Robbe Decorte
 */
data class EatingDayWithEntries (
    @Embedded
    var eatingDay: EatingDay? = null,

    @Relation(parentColumn = "dayId", entityColumn = "ownerId")
    var entries: List<FoodEntry> = ArrayList()
)