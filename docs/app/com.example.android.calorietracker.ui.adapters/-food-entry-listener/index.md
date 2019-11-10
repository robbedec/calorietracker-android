[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [FoodEntryListener](./index.md)

# FoodEntryListener

`class FoodEntryListener`

Defining a click listener class, this method doesn't require you to store a full object reference
Use the id to make a database call when you need the object information

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Defining a click listener class, this method doesn't require you to store a full object reference Use the id to make a database call when you need the object information`FoodEntryListener(clickListener: (foodEntryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: (foodEntryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onClick](on-click.md) | `fun onClick(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.models/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
