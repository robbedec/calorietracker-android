package com.example.android.calorietracker.di

import com.example.android.calorietracker.PusherApplication
import com.example.android.calorietracker.data.network.BASE_URL
import com.example.android.calorietracker.data.network.CalorieTrackerApiService
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.ui.viewModels.FoodEntryDetailViewModel
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import com.example.android.calorietracker.ui.viewModels.SearchViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val mainModule = module {

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build() as Moshi
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request()
                val newRequest = request.newBuilder().addHeader("x-app-id", PusherApplication.appId)
                    .addHeader("x-app-key", PusherApplication.appKey)
                it.proceed(newRequest.build())
            }
            .build() as OkHttpClient
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory()) // -> let's you use something else than the default Call class (in this case the coroutine Deferred)
            .baseUrl(BASE_URL)
            .client(get())
            .build() as Retrofit
    }

    single { CalorieDatabase.getInstance(get()) }

    single { provideCalorieTrackerApiService(get()) }

    single { FoodRepository(get(), get()) }

    viewModel { HomeViewModel(get()) }

    viewModel { SearchViewModel(get()) }

    viewModel { (entryId : Long) -> FoodEntryDetailViewModel(get(), entryId) }
}


/**
 * [Retrofit] instance to make API calls.
 *
 * @param retrofit The base class from which an instance is created.
 * @return A retrofit service that contains information about the API calls.
 */
private fun provideCalorieTrackerApiService(retrofit: Retrofit): CalorieTrackerApiService {
    return retrofit.create(CalorieTrackerApiService::class.java)
}