[app](../../index.md) / [com.example.android.calorietracker.data.network](../index.md) / [CalorieTrackerApiService](index.md) / [getNutrientInformationAsync](./get-nutrient-information-async.md)

# getNutrientInformationAsync

`@GET("utils/nutrients") abstract fun getNutrientInformationAsync(): Deferred<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NutrientInfo`](../../com.example.android.calorietracker.data.network.dto/-nutrient-info/index.md)`>>`

Request a nutrition transformation utility

**Return**

a coroutine job that returns the value from the api.




[Deferred](#) has an await suspend function that waits for the result without blocking the UI.
Can throw HTTP errors when processing the request

**Author**
Robbe Decorte

