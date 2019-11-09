package com.example.android.calorietracker.ui.viewModels

import android.app.Application
import android.text.format.DateUtils
import android.view.animation.Transformation
import androidx.lifecycle.*
import com.example.android.calorietracker.data.models.EatingDay
import com.example.android.calorietracker.data.models.EatingDayWithEntries
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.utils.BaseCommand
import com.example.android.calorietracker.utils.SingleLiveEvent
import com.example.android.calorietracker.utils.formatAmount
import com.example.android.calorietracker.utils.formatGoal
import kotlinx.coroutines.*
import timber.log.Timber
import java.util.*

class HomeViewModel(val database: EatingDayDao, application: Application) : AndroidViewModel(application) {

    /**
     * The current amount of calories
     */
    var currentCalories: LiveData<Int> = Transformations.map(database.getAmountCalories()) {
        formatAmount(it ?: 0)
    }

    /**
     * The maximum amount of calories (the goal that the user wants to reach
     */
    val goal: LiveData<Int> = Transformations.map(database.getLimitCalories()) {
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

    /**
     * Used to stop every operation triggered by the ViewModel when it gets destroyed
     * Coroutine jobs will run on the main scope / thread
     */
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var currentDay = MutableLiveData<EatingDayWithEntries?>()

    /**
     * List of entries of the current day that get auto updated
     */
    var entries = database.getFoodEntries()

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
    val navigateToFoodEntryOverview
    get() = _navigateToFoodEntryOverview

    init {
        Timber.i("HomeViewModel created")
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
        viewModelJob.cancel()
    }

    /**
     * Init currentDay without blocking the ui thread while waiting for the result
     */
    private fun initializeCurrentDay() {
        uiScope.launch {
            currentDay.value = getTodayFromDatabase()
            entries = database.getFoodEntries()
        }
    }

    /**
     * Fetch the current day from the database or create a new one
     */
    private suspend fun getTodayFromDatabase(): EatingDayWithEntries? {
        return withContext(Dispatchers.IO) {
            var day = database.getToday()
            if(day == null) {
                uiScope.launch {
                    val newDay = EatingDay()
                    newDay.date = Calendar.getInstance().time

                    insert(newDay)

                    day = getTodayFromDatabase()
                    currentDay.value = getTodayFromDatabase()

                    Timber.i("$day")
                    Timber.i("Created from day == null")
                }
            }
            else if(!DateUtils.isToday(day?.eatingDay?.date!!.time)){
                // Check if the latest date in the database is from today

                uiScope.launch {
                    val newDay = EatingDay()
                    newDay.date = Calendar.getInstance().time

                    insert(newDay)
                    currentDay.value = getTodayFromDatabase()

                    Timber.i("Created from datecheck")
                }
            }

            // Return the correct day
            Timber.i("Returned $day")
            day
        }
    }

    private suspend fun insert(day: EatingDay) {
        withContext(Dispatchers.IO) {
            database.insert(day)
        }
    }

    private suspend fun insertFoodEntry(day: FoodEntry) {
        withContext(Dispatchers.IO) {
            database.insertFoodEntry(day)
        }
    }

    private fun addEntry(name: String, amount: Int){
        // TODO: Create method that receives new entry details with safeArgs and update the currentDay (Udacity-Lesson6-15-Exercise: Couroutines for Long running operations -> video 1 6:33
        uiScope.launch {
            val updatedDay = currentDay.value ?: return@launch

            var newEntry = FoodEntry()
            newEntry.ownerId = updatedDay.eatingDay!!.dayId
            newEntry.entryName = name
            newEntry.entryCalories = amount

            insertFoodEntry(newEntry)
        }
    }

    /**
     * Removes all the entries from this day
     */
    private fun clearEntries() {
        uiScope.launch {
            _showSnackbarEvent.value = true
            withContext(Dispatchers.IO) {
                database.clearEntries(currentDay.value!!.eatingDay!!.dayId)
                //database.clear()
            }
        }
    }

    /**
     * Method that gets called when a user wants to add calories to the counter
     */
    fun addCalories(checkedId: Int) {
        Timber.i("Value: %d", checkedId)

        when (checkedId) {
            0 -> {
                addFromState.value = BaseCommand.ApiSearch("Search with api")
            }
            1 -> {
                addFromState.value = BaseCommand.Manual("Add calories manual")
                clearEntries()
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

    fun onFoodEntryClicked(id: Long) {
        _navigateToFoodEntryOverview.value = id
    }

    /**
     * Reset to null to prevent bugs when configuration changes happen
     */
    fun onFoodEntryNavigated() {
        _navigateToFoodEntryOverview.value = null
    }
}
