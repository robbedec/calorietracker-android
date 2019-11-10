[app](../../index.md) / [com.example.android.calorietracker.utils](../index.md) / [DateConverter](./index.md)

# DateConverter

`class DateConverter`

Convert java.util.date to Long so it can be stored in the database.

In the future it might be interesting to implement an [alternative](www.github.com/JakeWharton/ThreeTenABP).

**Author**
Robbe Decorte

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Convert java.util.date to Long so it can be stored in the database.`DateConverter()` |

### Functions

| Name | Summary |
|---|---|
| [fromDate](from-date.md) | Convert [Date](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html) to [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html).`fun fromDate(date: `[`Date`](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |
| [toDate](to-date.md) | Convert [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) to [Date](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html).`fun toDate(dateLong: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Date`](https://docs.oracle.com/javase/6/docs/api/java/util/Date.html)`?` |
