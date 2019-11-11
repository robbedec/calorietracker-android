package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity

@Dao
interface FoodEntryDao {

    @Insert
    fun insert(entry: FoodEntryEntity)

    @Update
    fun update(entry: FoodEntryEntity)

    @Delete
    fun delete(entry: FoodEntryEntity)

    /*
     * Get entry by id
     */
    @Query("SELECT * FROM food_entry_table WHERE entryId = :key")
    fun get(key: Long): FoodEntryEntity

    /*
     * Remove all entries from the table
     */
    @Query("DELETE FROM food_entry_table")
    fun clear()

    /*
     * Get all food entries from the table
     * Automatically updates the live data when changes are recorded in the database
     */
    @Query("SELECT * FROM food_entry_table ORDER BY entryId DESC")
    fun getAllEntries(): LiveData<List<FoodEntryEntity>>
}