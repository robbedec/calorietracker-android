package com.example.android.calorietracker.data.network

import androidx.annotation.Nullable
import com.example.android.calorietracker.data.network.dto.CategoryProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://trackapi.nutritionix.com/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory()) // -> let's you use something else than the default Call class (in this case the coroutine Deferred
    .baseUrl(BASE_URL)
    .build()

interface CalorieTrackerApiService {

    /**
     * Request a collection of data based on a search query.
     *
     * @param query the string that should be searched for.
     * @param includeCommon should the category 'common' be included in the response.
     * @param includeSelf should the category 'self' be included in the response.
     *
     * [Deferred] has an await suspend function that waits for the result without blocking the UI.
     * Can throw HTTP errors when processing the request
     *
     * @author Robbe Decorte
     */
    @Headers("x-app-id: 21736d33", "x-app-key: 43931edd450bfcbe13ffe4439eb186c0")
    @GET("search/instant") // -> the api endpoint you want to use
    fun getResultsAsync(@Query("query") query: String, @Query("common") includeCommon: Boolean, @Query("self") includeSelf: Boolean): Deferred<CategoryProperty>
}

/**
 * [Retrofit] instance to make API calls.
 * This instance is a singleton
 */
object CalorieTrackerApi {
    val retrofitService: CalorieTrackerApiService by lazy {
        retrofit.create(CalorieTrackerApiService::class.java)
    }
}
