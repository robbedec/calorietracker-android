package com.example.android.calorietracker.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.data.models.FoodProperty
import com.example.android.calorietracker.data.models.enums.CalorieTrackerApiStatus
import com.example.android.calorietracker.ui.adapters.SearchResultAdapter

/**
 * Using BindingAdapters to fill a [RecyclerView] will automatically observe [LiveData].
 * The BindingAdapter will be called each time the list updates.
 *
 * @author Robbe Decorte
 */

/**
 * Bind the name of a [FoodEntry] to a [TextView].
 *
 * @param item contains the name you want to bind.
 */
@BindingAdapter("entryName")
fun TextView.setEntryName(item: FoodEntry?) {
    item?.let {
        text = item.entryName
    }
}

/**
 * Bind the amount of calories of a [FoodEntry] to a [TextView].
 *
 * @param item contains the amount you want to bind.
 */
@BindingAdapter("amountCalories")
fun TextView.setAmountCalories(item: FoodEntry?) {
    item?.let {
        text = item.entryCalories.toString()
    }
}

/**
 * Bind the list of search results to a [RecyclerView].
 *
 * @param recyclerView the view that should contain the list.
 * @param data the list that should be shown.
 */
@BindingAdapter("resultListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FoodProperty>?) {
    val adapter = recyclerView.adapter as SearchResultAdapter
    adapter.submitList(data)
}

/**
 * Visualize the API status.
 *
 * @param statusImageView view that holds the image.
 * @param status decides if the view should be visible and what image it should display.
 */
@BindingAdapter("calorieTrackerApiStatus")
fun bindStatus(statusImageView: ImageView, status: CalorieTrackerApiStatus?) {
    when(status) {
        CalorieTrackerApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CalorieTrackerApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CalorieTrackerApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}