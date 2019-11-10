package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.calorietracker.data.network.CalorieTrackerApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class SearchViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getResult()
    }

    private fun getResult() {
        CalorieTrackerApi.retrofitService.getResults().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
                Timber.i("robbe-failure: ${t.message}")
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
                Timber.i("robbe-succ: ${response.body()}")
            }

        })
        _response.value = "Set the api response here"
    }
}