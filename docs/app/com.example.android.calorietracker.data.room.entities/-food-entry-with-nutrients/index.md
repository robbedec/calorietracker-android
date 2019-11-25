[app](../../index.md) / [com.example.android.calorietracker.data.room.entities](../index.md) / [FoodEntryWithNutrients](./index.md)

# FoodEntryWithNutrients

`data class FoodEntryWithNutrients`

Database entity helper that embeds an [FoodEntry](../-food-entry/index.md) with the nutrients it contains.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Creates an [FoodEntryWithNutrients](./index.md) with default properties or with the properties provided in the constructor.`FoodEntryWithNutrients(foodEntry: `[`FoodEntry`](../-food-entry/index.md)`? = null, nutrients: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ClarifiedNutrient`](../-clarified-nutrient/index.md)`> = ArrayList())` |

### Properties

| Name | Summary |
|---|---|
| [foodEntry](food-entry.md) | the [FoodEntry](../-food-entry/index.md) object.`var foodEntry: `[`FoodEntry`](../-food-entry/index.md)`?` |
| [nutrients](nutrients.md) | a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [ClarifiedNutrient](../-clarified-nutrient/index.md) from the embedded [FoodEntry](../-food-entry/index.md).`var nutrients: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ClarifiedNutrient`](../-clarified-nutrient/index.md)`>` |
