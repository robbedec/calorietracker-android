[app](../../index.md) / [com.example.android.calorietracker.data.room.entities](../index.md) / [FoodEntry](./index.md)

# FoodEntry

`data class FoodEntry`

Represents a [FoodEntry](./index.md) that can be retrieved or pulled from the Room database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Creates an [FoodEntry](./index.md) with default properties or with the details provided in the constructor.`FoodEntry(entryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L, entryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "name", entryCalories: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, ownerId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L, apiId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", brandName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", image: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", imageBig: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", weight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0)` |

### Properties

| Name | Summary |
|---|---|
| [apiId](api-id.md) | key to get information about the entry from the online API, defaults to an empty string.`var apiId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [brandName](brand-name.md) | `var brandName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [entryCalories](entry-calories.md) | the amount of calories in the entry.`var entryCalories: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [entryId](entry-id.md) | the unique identifier.`var entryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [entryName](entry-name.md) | the display name of the entry.`var entryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [image](image.md) | `var image: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imageBig](image-big.md) | `var imageBig: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ownerId](owner-id.md) | foreign key that points to the id of [EatingDay](../-eating-day/index.md) that it belongs to.`var ownerId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [weight](weight.md) | `var weight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
