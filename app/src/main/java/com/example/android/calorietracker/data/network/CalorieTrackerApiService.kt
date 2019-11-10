package com.example.android.calorietracker.data.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://trackapi.nutritionix.com/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CalorieTrackerApiService {

    @Headers("x-app-id: 21736d33", "x-app-key: 43931edd450bfcbe13ffe4439eb186c0")
    @GET("search/instant?query=banana") // -> the api endpoint you want to use
    fun getResults():
            Call<String>
}

object CalorieTrackerApi {
    val retrofitService: CalorieTrackerApiService by lazy {
        retrofit.create(CalorieTrackerApiService::class.java)
    }
}