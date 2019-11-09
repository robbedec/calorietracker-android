package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.android.calorietracker.data.models.EatingDay
import com.example.android.calorietracker.data.models.EatingDayWithEntries
import com.example.android.calorietracker.data.models.FoodEntry

@Dao
interface EatingDayDao {

    @Insert
    fun insert(entry: EatingDay)

    @Insert
    fun insertFoodEntry(entry: FoodEntry)

    @Update
    fun update(entry: EatingDay)

    @Delete
    fun delete(entry: EatingDay)

    /**
     * Get day by id
     */
    @Query("SELECT * FROM daily_eating_table WHERE dayId = :key")
    fun get(key: Long): EatingDay

    /**
     * Remove all records from the table
     */
    @Query("DELETE FROM daily_eating_table")
    fun clear()

    @Query("DELETE FROM food_entry_table WHERE ownerId = :key")
    fun clearEntries(key: Long)

    /**
     * Get all day records from the table
     * Automatically updates the live data when changes are recorded in the database
     */
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC")
    fun getAllEntries(): LiveData<List<EatingDay>>

    /**
     * Returns the latest record in the table
     * Nullable in case there are no records in the table (after clearing table ...)
     * Includes all entries for that day
     */
    @Transaction
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getToday(): EatingDayWithEntries?

    @Query("SELECT * FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getFoodEntries(): LiveData<List<FoodEntry>>

    @Query("SELECT SUM(food_amount_calories) FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getAmountCalories(): LiveData<Int>
}