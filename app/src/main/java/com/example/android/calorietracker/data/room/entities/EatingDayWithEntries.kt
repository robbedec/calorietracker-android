package com.example.android.calorietracker.data.room.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Database entity that embeds an [EatingDayEntity] with the entries from that day.
 *
 * @property eatingDay the [EatingDayEntity] object.
 * @property entries a [List] of [FoodEntryEntity] from the embedded [EatingDayEntity].
 * @constructor Creates an [EatingDayWithEntries] with default properties or with the properties provided in the constructor.
 *
 * @author Robbe Decorte
 */
data class EatingDayWithEntries (
    @Embedded
    var eatingDay: EatingDayEntity? = null,

    @Relation(parentColumn = "dayId", entityColumn = "ownerId")
    var entries: List<FoodEntryEntity> = ArrayList()
)