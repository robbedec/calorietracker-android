package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.*
import com.example.android.calorietracker.data.network.CalorieTrackerApi
import com.example.android.calorietracker.data.network.dto.CategoryProperty
import com.example.android.calorietracker.data.network.dto.FoodProperty
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.domain.enums.CalorieTrackerApiStatus
import kotlinx.coroutines.*
import timber.log.Timber


/**
 * The [ViewModel] that is attached to [SearchFragment]
 */
class SearchViewModel(private val foodRepository: FoodRepository) : ViewModel() {


    /**
     * The current status of the Api request
     * LOADING - ERROR - DONE
     */
    private val _status = MutableLiveData<CalorieTrackerApiStatus>()
    val status: LiveData<CalorieTrackerApiStatus>
        get() = _status

    /**
     * The api result
     * Based on searchQuery and updates automatically when the searchQuery changes
     */
    private val _searchResult = MediatorLiveData<CategoryProperty>()
    val searchResult: LiveData<CategoryProperty>
        get() = _searchResult

    /**
     * The current value that the user wants to search for
     */
    var searchQuery = MutableLiveData<String>()

    init {

        /**
         * Update the result list when the searchQuery changes
         */
        _searchResult.addSource(searchQuery) {
            if(searchQuery.value!!.isNotEmpty()){
                getResult()
            } else {
                _searchResult.value = CategoryProperty(ArrayList())
            }
        }
    }

    private fun getResult() {
        viewModelScope.launch {
            // Let coroutines manage concurrency on the main thread
            try {
                _status.value = CalorieTrackerApiStatus.LOADING

                // This will run on a thread managed by Retrofit
                var result = foodRepository.search(searchQuery.value!!) // Await is non blocking

                _status.value = CalorieTrackerApiStatus.DONE
                _searchResult.value = result

            } catch (t: Throwable) {
                _status.value = CalorieTrackerApiStatus.ERROR

                // Clear the RecyclerView when an error occurs
                _searchResult.value = CategoryProperty(ArrayList())

                Timber.i(t.message)
            }
        }
    }

    /**
     * Stop loading data when the [ViewModel] is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun onSearchEntryClicked(entry: FoodProperty) {
        viewModelScope.launch {
            try {
                val list = CalorieTrackerApi.retrofitService.getNutrientInformationAsync().await()
                foodRepository.insertFoodEntryWithNutrients(entry)



            }catch (t: Throwable) {

                Timber.i(t.message)
            }

        }
    }
 }