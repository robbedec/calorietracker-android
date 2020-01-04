package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.data.room.entities.ClarifiedNutrient
import com.example.android.calorietracker.databinding.RowNutritionInfoBinding

class NutritionAdapter : ListAdapter<ClarifiedNutrient, NutritionAdapter.NutritionViewHolder>(DiffCallback) {

    class NutritionViewHolder(private var binding: RowNutritionInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nutrient: ClarifiedNutrient) {
            binding.nutritionLine = nutrient

            /**
             * Execute the update immediately
             * Prevents the [RecyclerView] to make unnecessary calculations when figuring out how to display the list
             */
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ClarifiedNutrient>() {
        override fun areItemsTheSame(oldItem: ClarifiedNutrient, newItem: ClarifiedNutrient): Boolean {
            // Referential equality operator (===)
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ClarifiedNutrient, newItem: ClarifiedNutrient): Boolean {
            return oldItem.nutId == newItem.nutId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        return NutritionViewHolder(RowNutritionInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NutritionViewHolder, position: Int) {
        val nutrientLine = getItem(position)
        holder.bind(nutrientLine)
    }
}
