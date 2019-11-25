[app](../../index.md) / [com.example.android.calorietracker.data.network.dto](../index.md) / [FoodProperty](./index.md)

# FoodProperty

`data class FoodProperty`

Holds 1 category that can be retrieved from the API.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Holds 1 category that can be retrieved from the API.`FoodProperty(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, brandName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, amountCal: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, image: `[`Photo`](../-photo/index.md)`, nutrients: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`AbstractNutrient`](../-abstract-nutrient/index.md)`>, _weight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`? = 0.0)` |

### Properties

| Name | Summary |
|---|---|
| [amountCal](amount-cal.md) | the amount of calories in the property.`val amountCal: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [brandName](brand-name.md) | `val brandName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [id](id.md) | the unique identifier.`val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [image](image.md) | `val image: `[`Photo`](../-photo/index.md) |
| [name](name.md) | the display name of the property.`val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [nutrients](nutrients.md) | `var nutrients: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`AbstractNutrient`](../-abstract-nutrient/index.md)`>` |
| [weight](weight.md) | `val weight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [asDatabaseEntity](../../com.example.android.calorietracker.utils/as-database-entity.md) | `fun `[`FoodProperty`](./index.md)`.asDatabaseEntity(): `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) |
