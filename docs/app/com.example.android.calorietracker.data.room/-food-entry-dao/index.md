[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [FoodEntryDao](./index.md)

# FoodEntryDao

`interface FoodEntryDao`

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `abstract fun delete(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `abstract fun get(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) |
| [getAmountCalories](get-amount-calories.md) | Gets the amount of calories registered from the last [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) in the database.`abstract fun getAmountCalories(): LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [getFoodEntries](get-food-entries.md) | `abstract fun getFoodEntries(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`>>` |
| [getFoodEntry](get-food-entry.md) | Get a [FoodEntry](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) by it's id.`abstract fun getFoodEntry(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) |
| [getFoodEntryWithNutrients](get-food-entry-with-nutrients.md) | `abstract fun getFoodEntryWithNutrients(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntryWithNutrients`](../../com.example.android.calorietracker.data.room.entities/-food-entry-with-nutrients/index.md) |
| [insert](insert.md) | `abstract fun insert(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [insertAllNutrients](insert-all-nutrients.md) | `abstract fun insertAllNutrients(nutrients: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ClarifiedNutrient`](../../com.example.android.calorietracker.data.room.entities/-clarified-nutrient/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [update](update.md) | `abstract fun update(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
