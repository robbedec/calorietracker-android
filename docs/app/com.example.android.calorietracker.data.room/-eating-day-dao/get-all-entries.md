[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [EatingDayDao](index.md) / [getAllEntries](./get-all-entries.md)

# getAllEntries

`abstract fun getAllEntries(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`EatingDay`](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)`>>`

Get all day records from the table
Automatically updates the live data when changes are recorded in the database

**Return**
a [LiveData](#) object that holds a list of [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md)

