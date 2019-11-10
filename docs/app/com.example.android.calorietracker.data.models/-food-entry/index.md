[app](../../index.md) / [com.example.android.calorietracker.data.models](../index.md) / [FoodEntry](./index.md)

# FoodEntry

`data class FoodEntry`

Represents a [FoodEntry](./index.md) that can be retrieved or pulled from the Room database.

### Constructors

| [&lt;init&gt;](-init-.md) | Creates an [FoodEntry](./index.md) with default properties or with the details provided in the constructor.`FoodEntry(entryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L, entryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "name", entryCalories: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, ownerId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L)` |

### Properties

| [entryCalories](entry-calories.md) | the amount of calories in the entry.`var entryCalories: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [entryId](entry-id.md) | the unique identifier.`var entryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [entryName](entry-name.md) | the display name of the entry.`var entryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ownerId](owner-id.md) | foreign key that points to the id of [EatingDay](../-eating-day/index.md) that it belongs to.`var ownerId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

