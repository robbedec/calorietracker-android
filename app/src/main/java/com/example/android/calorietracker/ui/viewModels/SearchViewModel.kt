package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.calorietracker.data.models.CategoryProperty
import com.example.android.calorietracker.data.network.CalorieTrackerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber


class SearchViewModel() : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _searchResult = MutableLiveData<CategoryProperty>()
    val searchResult: LiveData<CategoryProperty>
        get() = _searchResult

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getResult()
    }

    private fun getResult() {

        coroutineScope.launch {
            // Let coroutines manage concurrency on the main thread
            var getResultsDeferred = CalorieTrackerApi.retrofitService.getResults()
            try {
                var result = getResultsDeferred.await() // Await is non blocking
                _response.value = "Succes: ${result.branded?.get(0)?.name} and amount: ${result.branded?.get(0)?.amountCal}"
                _searchResult.value = result
            } catch (t: Throwable) {
                _response.value = "Failure: " + t.message
                Timber.i("robbe-failure: ${t.message}")
            }
        }
    }

    /**
     * Stop loading data when the [ViewModel] is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}