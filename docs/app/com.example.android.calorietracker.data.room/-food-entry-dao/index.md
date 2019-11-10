[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [FoodEntryDao](./index.md)

# FoodEntryDao

`interface FoodEntryDao`

### Functions

| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `abstract fun delete(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `abstract fun get(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md) |
| [getAllEntries](get-all-entries.md) | `abstract fun getAllEntries(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`>>` |
| [insert](insert.md) | `abstract fun insert(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [update](update.md) | `abstract fun update(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

