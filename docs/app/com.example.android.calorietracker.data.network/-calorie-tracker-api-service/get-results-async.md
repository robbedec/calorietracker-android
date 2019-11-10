[app](../../index.md) / [com.example.android.calorietracker.data.network](../index.md) / [CalorieTrackerApiService](index.md) / [getResultsAsync](./get-results-async.md)

# getResultsAsync

`@Headers(["x-app-id: 21736d33", "x-app-key: 43931edd450bfcbe13ffe4439eb186c0"]) @GET("search/instant") abstract fun getResultsAsync(@Query("query") query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("common") includeCommon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, @Query("self") includeSelf: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Deferred<`[`CategoryProperty`](../../com.example.android.calorietracker.data.models/-category-property/index.md)`>`

Request a collection of data based on a search query.

### Parameters

`query` - the string that should be searched for.

`includeCommon` - should the category 'common' be included in the response.

`includeSelf` -

should the category 'self' be included in the response.




[Deferred](#) has an await suspend function that waits for the result without blocking the UI.
Can throw HTTP errors when processing the request

**Author**
Robbe Decorte

