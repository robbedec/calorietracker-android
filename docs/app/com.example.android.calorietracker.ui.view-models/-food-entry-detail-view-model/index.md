[app](../../index.md) / [com.example.android.calorietracker.ui.viewModels](../index.md) / [FoodEntryDetailViewModel](./index.md)

# FoodEntryDetailViewModel

`class FoodEntryDetailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FoodEntryDetailViewModel(foodRepository: `[`FoodRepository`](../../com.example.android.calorietracker.domain/-food-repository/index.md)`, entryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [burnCalories](burn-calories.md) | `val burnCalories: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [product](product.md) | `val product: LiveData<`[`FoodEntryWithNutrients`](../../com.example.android.calorietracker.data.room.entities/-food-entry-with-nutrients/index.md)`>` |
