package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.models.FoodEntry
import kotlinx.android.synthetic.main.row_food_entry.view.*

class FoodEntryAdapter : RecyclerView.Adapter<FoodEntryHolder>() {
    var data = listOf<FoodEntry>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FoodEntryHolder, position: Int) {
        val item = data[position]
        //holder.view.text = item.entryName.toString()

        holder.name.text = item.entryName
        holder.amount.text = item.entryCalories.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEntryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_food_entry, parent, false)
        return FoodEntryHolder(view)
    }
}

class FoodEntryHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val name = view.primary_text!!
    val amount = view.sub_text!!
}