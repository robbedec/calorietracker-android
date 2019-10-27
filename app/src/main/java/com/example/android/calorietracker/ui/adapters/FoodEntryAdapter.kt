package com.example.android.calorietracker.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.models.FoodEntry
import kotlinx.android.synthetic.main.row_food_entry.view.*
import timber.log.Timber

class FoodEntryAdapter : RecyclerView.Adapter<FoodEntryAdapter.FoodEntryHolder>() {
    var data = listOf<FoodEntry>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FoodEntryHolder, position: Int) {
       /*
        * Make sure that you change view specific properties that aren't updated for each new element (e.g. the foreground of the primary_text)
        * The recyclerView won't reset properties that aren't explicitly called
        */

        val item = data[position]

        holder.name.text = item.entryName
        holder.amount.text = item.entryCalories.toString()

        /*
         * Navigate to entry overview -> give the item in the current card as a parameter
         */
        holder.view.setOnClickListener {
            Timber.i("Item from recycler clicked!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEntryHolder {
        return FoodEntryHolder.from(parent)
    }

    /*
     * Make private because it should not be called outside this class
     * Contains all logic to manage views = separation of concerns
     */
    class FoodEntryHolder private constructor(val view: View) : ViewHolder(view) {
        val name = view.primary_text!!
        val amount = view.sub_text!!

        companion object {
            fun from(parent: ViewGroup): FoodEntryHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.row_food_entry, parent, false)
                return FoodEntryHolder(view)
            }
        }
    }


}

