package com.example.android.calorietracker.data.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = ""

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CalorieTrackerApiService {
    @GET("search_results") // -> the api endpoint you want to use
    fun getResults(searchText: String):
            Call<String>
}

object CalorieTrackerApi {
    val retrofitService: CalorieTrackerApiService by lazy {
        retrofit.create(CalorieTrackerApiService::class.java)
    }
}