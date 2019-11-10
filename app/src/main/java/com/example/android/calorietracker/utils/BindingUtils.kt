package com.example.android.calorietracker.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.data.models.FoodProperty
import com.example.android.calorietracker.ui.adapters.SearchResultAdapter

/**
 * Using [BindingAdapter] to fill a [RecyclerView] will automatically observe [LiveData]
 *
 * The [BindingAdapter] will be called each time the list updates
 */

@BindingAdapter("entryName")
fun TextView.setEntryName(item: FoodEntry?) {
    item?.let {
        text = item.entryName
    }
}

@BindingAdapter("amountCalories")
fun TextView.setAmountCalories(item: FoodEntry?) {
    item?.let {
        text = item.entryCalories.toString()
    }
}

@BindingAdapter("resultListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FoodProperty>?) {
    val adapter = recyclerView.adapter as SearchResultAdapter
    adapter.submitList(data)
}