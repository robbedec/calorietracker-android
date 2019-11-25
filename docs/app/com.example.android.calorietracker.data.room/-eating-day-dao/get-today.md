[app](../../index.md) / [com.example.android.calorietracker.data.room](../index.md) / [EatingDayDao](index.md) / [getToday](./get-today.md)

# getToday

`abstract fun getToday(): `[`EatingDayWithEntries`](../../com.example.android.calorietracker.data.room.entities/-eating-day-with-entries/index.md)`?`

Get the last [EatingDay](../../com.example.android.calorietracker.data.room.entities/-eating-day/index.md) and include it's entries.
Nullable in case there are no records in the table (after clearing table ...)

**Return**
the last [EatingDayWithEntries](../../com.example.android.calorietracker.data.room.entities/-eating-day-with-entries/index.md) in the database.

