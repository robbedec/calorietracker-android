package com.example.android.calorietracker.ui.viewModels

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.text.format.DateUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.calorietracker.data.models.EatingDay
import com.example.android.calorietracker.data.models.EatingDayWithEntries
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.utils.BaseCommand
import com.example.android.calorietracker.utils.SingleLiveEvent
import kotlinx.coroutines.*
import timber.log.Timber

class HomeViewModel(val database: EatingDayDao, application: Application) : AndroidViewModel(application) {

    /*
     * The current amount of calories
     */
    private val _currentCalories = MutableLiveData<Int>()
    val currentCalories: LiveData<Int>
        get() = _currentCalories

    /*
     * The maximum amount of calories (the goal that the user wants to reach
     */
    val goal: MutableLiveData<Int>

    /*
     * The ratio between current amount of calories and the maximum amount
     */
    private val _percentage = MutableLiveData<Int>()
    val percentage: LiveData<Int>
        get() = _percentage

    /*
     * The options that are shown in de "add calories from" dialog
     */
    val dialogList: Array<String>

    val addFromState = SingleLiveEvent<BaseCommand>()

    /*
     * Used to stop every operation triggered by the ViewModel when it gets destroyed
     * Coroutine jobs will run on the main scope / thread
     */
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val currentDay = MutableLiveData<EatingDayWithEntries?>()

    init {
        Timber.i("HomeViewModel created")
        initializeCurrentDay()
        _currentCalories.value = 300
        goal = MutableLiveData(500)
        dialogList = arrayOf("Search online", "Manually", "From favorites")

        calcPercentage()
    }

    /*
     * ViewModal is destroyed and all current jobs will be cancelled
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /*
     * Init currentDay without blocking the ui thread while waiting for the result
     */
    private fun initializeCurrentDay() {
        uiScope.launch {
            currentDay.value = getTodayFromDatabase()
        }
    }

    /*
     * Fetch the current day from the database or create a new one
     */
    private suspend fun getTodayFromDatabase(): EatingDayWithEntries? {
        return withContext(Dispatchers.IO) {
            var day = database.getToday()
            if(day == null) {
                val newDay = EatingDay()
                //newDay.entries = ArrayList()
                insert(newDay)
                currentDay.value = getTodayFromDatabase()

                Timber.i("Created from day == null")
            }
            // Check if the latest date in the database is from today
            if(!DateUtils.isToday(day?.eatingDay?.date!!.time)){
                val newDay = EatingDay()
                //newDay.entries = ArrayList()
                insert(newDay)
                currentDay.value = getTodayFromDatabase()

                Timber.i("Created from datecheck")
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

    /*
     * Calculate the ratio between currentCalories and the goals
     * Is show in the middle of the circular progress bar
     */
    private fun calcPercentage() {
        _percentage.value = (_currentCalories.value!! * 100.0f / goal.value!!).toInt()
    }

    /*
     * Method that gets called when a user wants to add calories to the counter
     */
    fun addCalories(checkedId: Int) {
        Timber.i("Value: %d", checkedId)

        when (checkedId) {
            0 -> addFromState.value = BaseCommand.ApiSearch("Search with api")
            1 -> addFromState.value = BaseCommand.Favorites("Add calories manual")
            2 -> {
                addFromState.value = BaseCommand.Manual("Select from favorites")
                addEntry("Banaan", 20)
            }
        }
    }
}