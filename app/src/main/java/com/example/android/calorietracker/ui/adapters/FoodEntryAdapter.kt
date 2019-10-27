package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.databinding.RowFoodEntryBinding
import timber.log.Timber

class FoodEntryAdapter : ListAdapter<FoodEntry, FoodEntryAdapter.FoodEntryHolder>(FoodEntryDiffCallback()) {

    override fun onBindViewHolder(holder: FoodEntryHolder, position: Int) {
       /*
        * Make sure that you change view specific properties that aren't updated for each new element (e.g. the foreground of the primary_text)
        * The recyclerView won't reset properties that aren't explicitly called
        */

        // Default ListAdapter method
        val item = getItem(position)

        holder.bind(item)


        /*
         * Navigate to entry overview -> give the item in the current card as a parameter
         */
        /*holder.view.setOnClickListener {
            Timber.i("Item from recycler clicked!")
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEntryHolder {
        return FoodEntryHolder.from(parent)
    }

    /*
     * Make private because it should not be called outside this class
     * Contains all logic to manage views = separation of concerns
     *
     * binding.root returns the constrained layout from the layout file to the ViewHolder
     */
    class FoodEntryHolder private constructor(val binding: RowFoodEntryBinding) : ViewHolder(binding.root) {

        fun bind(item: FoodEntry) {
            binding.primaryText.text = item.entryName
            binding.subText.text = item.entryCalories.toString()
        }

        companion object {
            fun from(parent: ViewGroup): FoodEntryHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowFoodEntryBinding.inflate(layoutInflater, parent, false)
                return FoodEntryHolder(binding)
            }
        }
    }
}

class FoodEntryDiffCallback : DiffUtil.ItemCallback<FoodEntry>() {
    /*
     * Check when an entry is reloaded in de recyclerView
     * With these methods the recyclerView won't update all the items but just those that contain a new listItem
     */
    override fun areItemsTheSame(oldItem: FoodEntry, newItem: FoodEntry): Boolean {
        return oldItem.entryId == newItem.entryId
    }

    /*
     * Uses de generated equals method of a data class
     * Compares all the fields of the oldItem with those of the newItem
     */
    override fun areContentsTheSame(oldItem: FoodEntry, newItem: FoodEntry): Boolean {
        return oldItem == newItem
    }

}

