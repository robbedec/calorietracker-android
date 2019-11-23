package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.calorietracker.data.room.entities.FoodEntryWithNutrients
import com.example.android.calorietracker.domain.FoodRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class FoodEntryDetailViewModel(private val foodRepository: FoodRepository, entryId: Long) : ViewModel() {

    private val _product = MutableLiveData<FoodEntryWithNutrients>()
    val product: LiveData<FoodEntryWithNutrients>
        get() = _product


    init {
        viewModelScope.launch {
            _product.value = foodRepository.getNutrientsFromEntry(entryId)
            /*Timber.i(product.value.nutrients.size.toString())
            product.nutrients.forEach {
                Timber.i(product.foodEntry!!.entryName)
                Timber.i(it.name + " " + it.unit + " " + it.value)
            }*/
        }
    }
}