package com.example.android.calorietracker.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.calorietracker.data.models.FoodEntry

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