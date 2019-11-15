package com.example.android.calorietracker.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.network.dto.FoodProperty
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity
import com.example.android.calorietracker.domain.enums.CalorieTrackerApiStatus
import com.example.android.calorietracker.ui.adapters.SearchResultAdapter
import kotlin.math.roundToInt

/**
 * Using BindingAdapters to fill a [RecyclerView] will automatically observe [LiveData].
 * The BindingAdapter will be called each time the list updates.
 *
 * @author Robbe Decorte
 */

/**
 * Bind the name of a [FoodEntryEntity] to a [TextView].
 *
 * @param item contains the name you want to bind.
 */
@BindingAdapter("entryName")
fun TextView.setEntryName(item: FoodEntryEntity?) {
    item?.let {
        text = item.entryName
    }
}

/**
 * Bind the amount of calories of a [FoodEntryEntity] to a [TextView].
 *
 * @param item contains the amount you want to bind.
 */
@BindingAdapter("amountCalories")
fun TextView.setAmountCalories(item: FoodEntryEntity?) {
    item?.let {
        text = item.entryCalories.toString() + " cal"
    }
}

@BindingAdapter("amountCal")
fun TextView.setAmountCalories(item: FoodProperty?) {
    item?.let {
        text = item.amountCal.roundToInt().toString() + " cal"
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

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if(imgUrl.isNullOrEmpty()) {
        imgView.setImageResource(R.drawable.broken_image)
    } else {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .into(imgView)
        }
    }
}