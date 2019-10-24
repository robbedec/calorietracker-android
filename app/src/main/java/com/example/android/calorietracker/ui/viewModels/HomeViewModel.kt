package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.calorietracker.utils.BaseCommand
import com.example.android.calorietracker.utils.SingleLiveEvent
import timber.log.Timber

class HomeViewModel : ViewModel() {

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

    val dialogList: Array<String>

    val addFromState = SingleLiveEvent<BaseCommand>()

    init {
        Timber.i("HomeViewModel created")
        _currentCalories.value = 250
        goal = MutableLiveData(500)
        dialogList = arrayOf("Search online", "Manually", "From favorites")

        calcPercentage()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }

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
            1 -> addFromState.value = BaseCommand.Favorites("Select from favorites")
            2 -> addFromState.value = BaseCommand.Manual("Add calories manual")
        }
    }
}