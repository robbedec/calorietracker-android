[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [EatingDayDao](./index.md)

# EatingDayDao

`interface EatingDayDao`

Collection of database queries.

**Author**
Robbe Decorte

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | Remove all records from [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) table`abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [clearEntries](clear-entries.md) | Remove all food entries from the database`abstract fun clearEntries(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `abstract fun delete(entry: `[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | Get [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) by id.`abstract fun get(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) |
| [getAllEntries](get-all-entries.md) | Get all day records from the table Automatically updates the live data when changes are recorded in the database`abstract fun getAllEntries(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)`>>` |
| [getLimitCalories](get-limit-calories.md) | Gets the calorie intake limit from the last [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) in the database.`abstract fun getLimitCalories(): LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [getToday](get-today.md) | Get the last [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) and include it's entries. Nullable in case there are no records in the table (after clearing table ...)`abstract fun getToday(): `[`EatingDayWithEntries`](../../com.example.android.calorietracker.data.room.entities/-eating-day-with-entries/index.md)`?` |
| [insert](insert.md) | `abstract fun insert(entry: `[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [update](update.md) | `abstract fun update(entry: `[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
