[app](../../index.md) / [com.example.android.calorietracker.data.network](../index.md) / [CalorieTrackerApiService](./index.md)

# CalorieTrackerApiService

`interface CalorieTrackerApiService`

### Functions

| Name | Summary |
|---|---|
| [getNutrientInformationAsync](get-nutrient-information-async.md) | Request a nutrition transformation utility`abstract fun getNutrientInformationAsync(): Deferred<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NutrientInfo`](../../com.example.android.calorietracker.data.network.dto/-nutrient-info/index.md)`>>` |
| [getResultsAsync](get-results-async.md) | Request a collection of data based on a search query.`abstract fun getResultsAsync(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, includeCommon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, includeSelf: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, detailed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Deferred<`[`CategoryProperty`](../../com.example.android.calorietracker.data.network.dto/-category-property/index.md)`>` |
