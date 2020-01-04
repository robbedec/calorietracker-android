package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.*
import com.example.android.calorietracker.data.room.entities.FoodEntryWithNutrients
import com.example.android.calorietracker.domain.CalorieBurningCalculator
import com.example.android.calorietracker.domain.FoodRepository
import kotlinx.coroutines.launch

class FoodEntryDetailViewModel(private val foodRepository: FoodRepository, entryId: Long) : ViewModel() {

    private val _product = MutableLiveData<FoodEntryWithNutrients>()
    val product: LiveData<FoodEntryWithNutrients>
        get() = _product

    private val _burnCalories = MediatorLiveData<String>()
    val burnCalories: LiveData<String>
        get() = _burnCalories



    init {
        viewModelScope.launch {
            _product.value = foodRepository.getNutrientsFromEntry(entryId)
        }

        _burnCalories.addSource(_product) {
            val calorieMap = CalorieBurningCalculator(amountCal = it.foodEntry!!.entryCalories).calculate()
            _burnCalories.value = ""
            for((key, value) in calorieMap) {
                _burnCalories.value += "${key.capitalize()} takes $value minutes \n\n"
            }
        }
    }
}