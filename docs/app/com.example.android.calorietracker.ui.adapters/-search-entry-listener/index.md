[app](../../index.md) / [com.example.android.calorietracker.ui.adapters](../index.md) / [SearchEntryListener](./index.md)

# SearchEntryListener

`class SearchEntryListener`

Defining a click listener class, this method doesn't require you to store a full object reference
Use the id to make a database call when you need the object information

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Defining a click listener class, this method doesn't require you to store a full object reference Use the id to make a database call when you need the object information`SearchEntryListener(clickListener: (entry: `[`FoodProperty`](../../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: (entry: `[`FoodProperty`](../../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onClick](on-click.md) | `fun onClick(entry: `[`FoodProperty`](../../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
