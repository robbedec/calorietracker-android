package com.example.android.calorietracker.data.network

import com.example.android.calorietracker.data.network.dto.*
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://trackapi.nutritionix.com/v2/"

interface CalorieTrackerApiService {

    /**
     * Request a collection of data based on a search query.
     *
     * @param query the string that should be searched for.
     * @param includeCommon should the category 'common' be included in the response.
     * @param includeSelf should the category 'self' be included in the response.
     * @return a coroutine job that returns the value from the api.
     *
     * [Deferred] has an await suspend function that waits for the result without blocking the UI.
     * Can throw HTTP errors when processing the request
     *
     * @author Robbe Decorte
     */
    @GET("search/instant")
    fun getResultsAsync(@Query("query") query: String, @Query("common") includeCommon: Boolean, @Query("self") includeSelf: Boolean, @Query("detailed") detailed: Boolean): Deferred<CategoryProperty>

    /**
     * Request a nutrition transformation utility
     *
     * @return a coroutine job that returns the value from the api.
     *
     * [Deferred] has an await suspend function that waits for the result without blocking the UI.
     * Can throw HTTP errors when processing the request
     *
     * @author Robbe Decorte
     */
    @GET("utils/nutrients")
    fun getNutrientInformationAsync() : Deferred<List<NutrientInfo>>
}