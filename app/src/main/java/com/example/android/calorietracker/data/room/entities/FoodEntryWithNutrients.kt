package com.example.android.calorietracker.data.room.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Database entity helper that embeds an [FoodEntry] with the nutrients it contains.
 *
 * @property foodEntry the [FoodEntry] object.
 * @property nutrients a [List] of [ClarifiedNutrient] from the embedded [FoodEntry].
 * @constructor Creates an [FoodEntryWithNutrients] with default properties or with the properties provided in the constructor.
 *
 * @author Robbe Decorte
 */
data class FoodEntryWithNutrients(
    @Embedded
    var foodEntry: FoodEntry? = null,

    @Relation(parentColumn = "entryId", entityColumn = "parentId", entity = ClarifiedNutrient::class)
    var nutrients: List<ClarifiedNutrient> = ArrayList()
)