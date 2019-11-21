package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.calorietracker.data.room.entities.ClarifiedNutrient
import com.example.android.calorietracker.data.room.entities.EatingDay
import com.example.android.calorietracker.data.room.entities.FoodEntry
import com.example.android.calorietracker.data.room.entities.FoodEntryWithNutrients

@Dao
interface FoodEntryDao {

    @Insert
    fun insert(entry: FoodEntry): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNutrients(nutrients: List<ClarifiedNutrient>)

    @Update
    fun update(entry: FoodEntry)

    @Delete
    fun delete(entry: FoodEntry)

    /*
     * Get entry by id
     */
    @Query("SELECT * FROM food_entry_table WHERE entryId = :key")
    fun get(key: Long): FoodEntry

    /*
     * Remove all entries from the table
     */
    @Query("DELETE FROM food_entry_table")
    fun clear()

    /**
     *
     * @return a [LiveData] object that holds a list of [FoodEntry] from the last (current) [EatingDay] in de database.
     */
    @Query("SELECT * FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getFoodEntries(): LiveData<List<FoodEntry>>

    /**
     * Gets the amount of calories registered from the last [EatingDay] in the database.
     *
     * @return a [LiveData] object that holds the total intake.
     */
    @Query("SELECT SUM(food_amount_calories) FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getAmountCalories(): LiveData<Int>

    /**
     * Get a [FoodEntry] by it's id.
     *
     * @param key The id of the item.
     * @return a [FoodEntry].
     */
    @Query("SELECT * FROM food_entry_table WHERE entryId = :key")
    fun getFoodEntry(key: Long): FoodEntry

    @Query("SELECT * FROM food_entry_table WHERE entryId = :key")
    fun getFoodEntryWithNutrients(key: Long): FoodEntryWithNutrients
}