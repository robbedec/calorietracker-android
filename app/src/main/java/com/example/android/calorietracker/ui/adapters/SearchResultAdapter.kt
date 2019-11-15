package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.data.network.dto.FoodProperty
import com.example.android.calorietracker.databinding.RowSearchResultBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.R
import kotlin.math.roundToInt


class SearchResultAdapter(private val clickListener: SearchEntryListener) : ListAdapter<FoodProperty, SearchResultAdapter.FoodPropertyViewHolder>(DiffCallback) {

    class FoodPropertyViewHolder(private var binding: RowSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodProperty: FoodProperty, clickListener: SearchEntryListener) {
            binding.property = foodProperty
            binding.clickListener = clickListener

            /**
             * Execute the update immediately
             * Prevents the [RecyclerView] to make unnecessary calculations when figuring out how to display the list
             */
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FoodProperty>() {
        override fun areItemsTheSame(oldItem: FoodProperty, newItem: FoodProperty): Boolean {
            // Referential equality operator (===)
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FoodProperty, newItem: FoodProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodPropertyViewHolder {
        return FoodPropertyViewHolder(RowSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FoodPropertyViewHolder, position: Int) {
        val foodProperty = getItem(position)
        holder.bind(foodProperty, clickListener)
    }
}

/**
 * Defining a click listener class, this method doesn't require you to store a full object reference
 * Use the id to make a database call when you need the object information
 */
class SearchEntryListener(val clickListener: (id: String, name: String, amountCal: Int) -> Unit) {
    fun onClick(entry: FoodProperty) = clickListener(entry.id, entry.name, entry.amountCal.roundToInt())
}