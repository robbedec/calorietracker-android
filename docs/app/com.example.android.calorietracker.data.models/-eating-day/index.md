[app](../../index.md) / [com.example.android.calorietracker.data.models](../index.md) / [EatingDay](./index.md)

# EatingDay

`data class EatingDay`

Represents a single day that can be stored and retrieved from the Room database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Creates an [EatingDay](./index.md) with default properties or with the details provided in the constructor.`EatingDay(dayId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L, date: `[`Date`](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html)` = Calendar.getInstance().time, amountCal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, limitCal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 5000)` |

### Properties

| Name | Summary |
|---|---|
| [amountCal](amount-cal.md) | the amount of calories that the user has registered.`val amountCal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [date](date.md) | the date when the entity was created.`var date: `[`Date`](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html) |
| [dayId](day-id.md) | the unique identifier.`var dayId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [limitCal](limit-cal.md) | number of calories that the user wants to eat in a day.`val limitCal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
