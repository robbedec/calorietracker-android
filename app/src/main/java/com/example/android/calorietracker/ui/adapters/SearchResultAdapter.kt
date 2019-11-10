package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.data.models.FoodProperty
import com.example.android.calorietracker.databinding.RowSearchResultBinding

class SearchResultAdapter : ListAdapter<FoodProperty, SearchResultAdapter.FoodPropertyViewHolder>(DiffCallback) {

    class FoodPropertyViewHolder(private var binding: RowSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodProperty: FoodProperty) {
            binding.property = foodProperty

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultAdapter.FoodPropertyViewHolder {
        return FoodPropertyViewHolder(RowSearchResultBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SearchResultAdapter.FoodPropertyViewHolder, position: Int) {
        val foodProperty = getItem(position)
        holder.bind(foodProperty)
    }
}