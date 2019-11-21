package com.example.android.calorietracker.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.calorietracker.domain.FoodRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class FoodEntryDetailViewModel(private val foodRepository: FoodRepository, entryId: Long) : ViewModel() {

    init {
        viewModelScope.launch {
            val item2 = foodRepository.getNutrientsFromEntry(entryId)
            Timber.i(item2.nutrients.size.toString())
            item2.nutrients.forEach {
                Timber.i(item2.foodEntry!!.entryName)
                Timber.i(it.name + " " + it.unit + " " + it.value)
            }
        }
    }
}