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

enum class CalorieTrackerApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to [SearchFragment]
 */
class SearchViewModel() : ViewModel() {

    private val _status = MutableLiveData<CalorieTrackerApiStatus>()
    val status: LiveData<CalorieTrackerApiStatus>
        get() = _status

    private val _searchResult = MutableLiveData<CategoryProperty>()
    val searchResult: LiveData<CategoryProperty>
        get() = _searchResult

    var searchQuery = MutableLiveData<String>()

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        //getResult()
    }

    fun getResult() {

        coroutineScope.launch {
            // Let coroutines manage concurrency on the main thread
            var getResultsDeferred = CalorieTrackerApi.retrofitService.getResultsAsync(searchQuery.value!!, false, false)
            try {
                _status.value = CalorieTrackerApiStatus.LOADING

                // This will run on a thread managed by Retrofit
                var result = getResultsDeferred.await() // Await is non blocking
                _status.value = CalorieTrackerApiStatus.DONE
                _searchResult.value = result

            } catch (t: Throwable) {
                _status.value = CalorieTrackerApiStatus.ERROR

                // Clear the RecyclerView when an error occurs
                _searchResult.value = CategoryProperty(ArrayList())
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