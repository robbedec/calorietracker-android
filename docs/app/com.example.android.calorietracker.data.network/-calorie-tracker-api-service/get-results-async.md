[app](../../index.md) / [com.example.android.calorietracker.data.network](../index.md) / [CalorieTrackerApiService](index.md) / [getResultsAsync](./get-results-async.md)

# getResultsAsync

`@GET("search/instant") abstract fun getResultsAsync(@Query("query") query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("common") includeCommon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, @Query("self") includeSelf: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, @Query("detailed") detailed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Deferred<`[`CategoryProperty`](../../com.example.android.calorietracker.data.network.dto/-category-property/index.md)`>`

Request a collection of data based on a search query.

### Parameters

`query` - the string that should be searched for.

`includeCommon` - should the category 'common' be included in the response.

`includeSelf` - should the category 'self' be included in the response.

**Return**

a coroutine job that returns the value from the api.




[Deferred](#) has an await suspend function that waits for the result without blocking the UI.
Can throw HTTP errors when processing the request

**Author**
Robbe Decorte

