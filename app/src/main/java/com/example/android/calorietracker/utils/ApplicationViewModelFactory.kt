package com.example.android.calorietracker.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import com.example.android.calorietracker.ui.viewModels.SearchViewModel
import java.lang.IllegalArgumentException

/**
 * Create a [ViewModel] and check if it needs to use a database instance.
 * A [ViewModel] can only be created with a no-argument constructor, we use a ViewModel Factory initializing with arguments.
 *
 * @property foodRepository contains all the data manipulation methods.
 *
 * @author Robbe Decorte
 */
class ApplicationViewModelFactory(private val foodRepository: FoodRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(foodRepository) as T
        }
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(foodRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}