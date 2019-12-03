package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.*
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.data.room.entities.EatingDayWithEntries
import com.example.android.calorietracker.data.room.entities.FoodEntry
import com.example.android.calorietracker.utils.BaseCommand
import com.example.android.calorietracker.utils.SingleLiveEvent
import com.example.android.calorietracker.utils.formatAmount
import com.example.android.calorietracker.utils.formatGoal
import kotlinx.coroutines.*
import timber.log.Timber

class HomeViewModel(private val repository: FoodRepository) : ViewModel() {

    /**
     * The current amount of calories
     */
    var currentCalories: LiveData<Int> = Transformations.map(repository.getAmountCalories()) {
        formatAmount(it ?: 0)
    }

    /**
     * The maximum amount of calories (the goal that the user wants to reach
     */
    val goal: LiveData<Int> = Transformations.map(repository.getLimitCalories()) {
        formatGoal(it ?: 5000)
    }

    /**
     * The ratio between current amount of calories and the maximum amount
     */
    private val _percentage = MediatorLiveData<Int>()
    val percentage: LiveData<Int>
        get() = _percentage

    /**
     * The options that are shown in de "add calories from" dialog
     */
    val dialogList: Array<String>

    val addFromState = SingleLiveEvent<BaseCommand>()

    private var currentDay = MutableLiveData<EatingDayWithEntries?>()

    /**
     * List of entries of the current day that get auto updated
     */
    var entries = repository.getFoodEntries()

    /**
     * Decide when to show SnackbarEvent at the bottom of the screen
     * Mostly when clearing the current day of data entries
     */
    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    /**
     * Navigation trigger
     * Contains the foodEntryId of the item you want to place in the overview
     */
    private val _navigateToFoodEntryOverview = MutableLiveData<Long>()
    val navigateToFoodEntryOverview: LiveData<Long>
        get() = _navigateToFoodEntryOverview

    /**
     * Should the fragment display an error alert if and entry in the list.
     * Is true if apiId is empty.
     */
    private val _showErrorAlert = MutableLiveData<Boolean>()
    val showErrorAlert: LiveData<Boolean>
        get() = _showErrorAlert

    init {
        initializeCurrentDay()

        dialogList = arrayOf("Search online", "Manually", "From favorites")

        /**
         * Check for updates in the liveData and adapt the value of the [MediatorLiveData], provide default values
         * for calculations before the real data is loaded from the database
         *
         * Calculates the ratio between currentCalories and the goals
         * Is shown in the middle of the circular progress bar
         */
        _percentage.addSource(currentCalories) { res ->
            if(currentCalories.value != null) {
                _percentage.value = (res * 100.0f / (goal.value ?: 5000)).toInt()
            } else {
                _percentage.value = 0
            }
        }

        _percentage.addSource(goal) { res ->
            _percentage.value = ((currentCalories.value ?: 0) * 100.0f / (res ?: 5000)).toInt()
        }

    }

    /**
     * ViewModal is destroyed and all current jobs will be cancelled
     */
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    /**
     * Init currentDay without blocking the ui thread while waiting for the result
     */
    private fun initializeCurrentDay() {
        viewModelScope.launch {
            currentDay.value = repository.getToday()
            entries = repository.getFoodEntries()
        }
    }

    fun addEntry(name: String, amount: Int){
        viewModelScope.launch {
            // If updatedDay == null, return to viewModelScope.launch without executing the other statements in this block.
            val updatedDay = currentDay.value ?: return@launch

            val newEntry = FoodEntry()
            newEntry.ownerId = updatedDay.eatingDay!!.dayId
            newEntry.entryName = name
            newEntry.entryCalories = amount

            repository.insertFoodEntry(newEntry)
        }
    }

    /**
     * Removes all the entries from this day
     */
    fun clearEntries() {
        viewModelScope.launch {
            _showSnackbarEvent.value = true
            repository.clearEntries()
        }
    }

    /**
     * Method that gets called when a user wants to add calories to the counter
     */
    fun addCaloriesSource(checkedId: Int) {
        when (checkedId) {
            0 -> {
                addFromState.value = BaseCommand.ApiSearch("Search with api")
            }
            1 -> {
                addFromState.value = BaseCommand.Manual("Add calories manual")
            }
            2 -> {
                addFromState.value = BaseCommand.Favorites("Select from favorites")
                addEntry("Banaan", 500)
            }
        }
    }

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }

    /**
     * Handles the click events from a [FoodEntry].
     *
     * @param id The id of the entry that was clicked.
     * @param action Decides which action to trigger.
     */
    fun onFoodEntryClicked(id: Long, action: Int) {
        when(action) {
            0 -> {
                viewModelScope.launch {
                    val entry = repository.getFoodEntry(id)
                    if(entry.apiId.isNotEmpty()) {
                        _navigateToFoodEntryOverview.value = entry.entryId
                    } else {
                        _showErrorAlert.value = true
                    }
                }
            }
            1 -> {
                viewModelScope.launch {
                    repository.removeEntry(id)
                }
            }
        }
    }

    /**
     * Reset to null to prevent bugs when configuration changes happen.
     */
    fun onFoodEntryNavigated() {
        _navigateToFoodEntryOverview.value = null
    }

    /**
     * Reset property to prevent bugs when configuration changes happen.
     */
    fun onErrorAlertShown() {
        _showErrorAlert.value = null
    }
}
