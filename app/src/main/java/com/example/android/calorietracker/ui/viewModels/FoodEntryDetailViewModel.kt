package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.*
import com.example.android.calorietracker.data.room.entities.FoodEntryWithNutrients
import com.example.android.calorietracker.domain.CalorieBurningCalculator
import com.example.android.calorietracker.domain.FoodRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class FoodEntryDetailViewModel(private val foodRepository: FoodRepository, entryId: Long) : ViewModel() {

    private val _product = MutableLiveData<FoodEntryWithNutrients>()
    val product: LiveData<FoodEntryWithNutrients>
        get() = _product

    private val _burnCalories = MediatorLiveData<Map<String, Int>>()
    val burnCalories: LiveData<Map<String, Int>>
        get() = _burnCalories



    init {
        viewModelScope.launch {
            _product.value = foodRepository.getNutrientsFromEntry(entryId)
        }

        _burnCalories.addSource(_product) {
            _burnCalories.value = CalorieBurningCalculator(amountCal = it.foodEntry!!.entryCalories).calculate()
        }
    }
}