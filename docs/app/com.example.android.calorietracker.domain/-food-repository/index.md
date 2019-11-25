[app](../../index.md) / [com.example.android.calorietracker.domain](../index.md) / [FoodRepository](./index.md)

# FoodRepository

`class FoodRepository`

Repository for fetching data from the database or API.

### Parameters

`database` - Instance of the in memory database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Repository for fetching data from the database or API.`FoodRepository(database: `[`CalorieDatabase`](../../com.example.android.calorietracker.data.room/-calorie-database/index.md)`, apiService: `[`CalorieTrackerApiService`](../../com.example.android.calorietracker.data.network/-calorie-tracker-api-service/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [clearDays](clear-days.md) | `suspend fun clearDays(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [clearEntries](clear-entries.md) | `suspend fun clearEntries(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAmountCalories](get-amount-calories.md) | `fun getAmountCalories(): LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [getFoodEntries](get-food-entries.md) | `fun getFoodEntries(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`>>` |
| [getFoodEntry](get-food-entry.md) | `suspend fun getFoodEntry(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md) |
| [getLimitCalories](get-limit-calories.md) | `fun getLimitCalories(): LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [getNutrientsFromEntry](get-nutrients-from-entry.md) | `suspend fun getNutrientsFromEntry(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`FoodEntryWithNutrients`](../../com.example.android.calorietracker.data.room.entities/-food-entry-with-nutrients/index.md) |
| [getNutrientsUtil](get-nutrients-util.md) | `suspend fun getNutrientsUtil(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NutrientInfo`](../../com.example.android.calorietracker.data.network.dto/-nutrient-info/index.md)`>` |
| [getToday](get-today.md) | `suspend fun getToday(): `[`EatingDayWithEntries`](../../com.example.android.calorietracker.data.room.entities/-eating-day-with-entries/index.md)`?` |
| [insertFoodEntry](insert-food-entry.md) | `suspend fun insertFoodEntry(entry: `[`FoodEntry`](../../com.example.android.calorietracker.data.room.entities/-food-entry/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [insertFoodEntryWithNutrients](insert-food-entry-with-nutrients.md) | `suspend fun insertFoodEntryWithNutrients(entry: `[`FoodProperty`](../../com.example.android.calorietracker.data.network.dto/-food-property/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeEntry](remove-entry.md) | `suspend fun removeEntry(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [search](search.md) | `suspend fun search(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CategoryProperty`](../../com.example.android.calorietracker.data.network.dto/-category-property/index.md) |
