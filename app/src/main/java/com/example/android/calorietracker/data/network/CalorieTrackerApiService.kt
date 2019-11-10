package com.example.android.calorietracker.data.network

import com.example.android.calorietracker.data.models.CategoryProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

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
     * [Deferred] has an await suspend function that waits for the result without blocking the UI
     * Throws an exception when an error occurs
     */
    @Headers("x-app-id: 21736d33", "x-app-key: 43931edd450bfcbe13ffe4439eb186c0")
    @GET("search/instant?query=banana&common=false&self=false") // -> the api endpoint you want to use
    fun getResults():
            Deferred<CategoryProperty>
}

object CalorieTrackerApi {
    val retrofitService: CalorieTrackerApiService by lazy {
        retrofit.create(CalorieTrackerApiService::class.java)
    }
}