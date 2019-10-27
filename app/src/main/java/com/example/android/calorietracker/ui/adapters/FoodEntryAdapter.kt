package com.example.android.calorietracker.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.models.FoodEntry
import com.example.android.calorietracker.databinding.RowFoodEntryBinding
import kotlinx.android.synthetic.main.row_food_entry.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ClassCastException


/**
 * Used to tell the [RecyclerView] which items it can reuse to load new data in
 */
private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class FoodEntryAdapter(private val clickListener: FoodEntryListener) : ListAdapter<DataItem, RecyclerView.ViewHolder>(FoodEntryDiffCallback()) {

    private val adapterScore = CoroutineScope(Dispatchers.Default)

    /**
     * Called when [RecyclerView] needs to show an item
     *
     * The [RecyclerView.ViewHolder] may be recycled, so make sure that this sets any properties that may have been set previously
     * The [RecyclerView] won't reset properties that aren't explicitly called
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FoodEntryHolder -> {
                val entryItem = getItem(position) as DataItem.FoodEntryItem
                holder.bind(entryItem.foodEntry, clickListener)
            }
        }
    }

    /**
     * Called when RecyclerView needs a new [RecyclerView.ViewHolder]
     *
     * The ViewHolder holds a view for the [RecyclerView] and provides additional information
     * such as the place on screen and where it was last drawn during scrolling
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> FoodEntryHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    /*
     * Return the type of the current item
     */
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.FoodEntryItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    /*
     * Add header to the front of the list
     */
    fun addHeaderAndSubmitList(list: List<FoodEntry>?) {
        adapterScore.launch {
            val items = when(list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map { DataItem.FoodEntryItem(it) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    /*
     * Make private because it should not be called outside this class
     * Contains all logic to manage views = separation of concerns
     *
     * binding.root returns the constrained layout from the layout file to the ViewHolder
     */
    class FoodEntryHolder private constructor(val binding: RowFoodEntryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FoodEntry, clickListener: FoodEntryListener) {
            binding.foodEntry = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FoodEntryHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowFoodEntryBinding.inflate(layoutInflater, parent, false)
                return FoodEntryHolder(binding)
            }
        }
    }

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_food_entry_header, parent, false)
                return TextViewHolder(view)
            }
        }
    }
}

class FoodEntryDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    /*
     * Check when an entry is reloaded in de recyclerView
     * With these methods the recyclerView won't update all the items but just those that contain a new listItem
     */
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    /*
     * Uses de generated equals method of a data class
     * Compares all the fields of the oldItem with those of the newItem
     */
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.equals(newItem)
    }
}

/*
 * Defining a click listener class, this method doesn't require you to store a full object reference
 * Use the id to make a database call when you need the object information
 */
class FoodEntryListener(val clickListener: (foodEntryId: Long) -> Unit) {
    fun onClick(entry: FoodEntry) = clickListener(entry.entryId)
}

sealed class DataItem {
    data class FoodEntryItem(val foodEntry: FoodEntry): DataItem() {
        override val id = foodEntry.entryId
    }
    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}

