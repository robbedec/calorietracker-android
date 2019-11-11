package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.calorietracker.data.room.entities.EatingDayEntity
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity
import com.example.android.calorietracker.domain.FoodEntry

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

    /**
     *
     * @return a [LiveData] object that holds a list of [FoodEntryEntity] from the last (current) [EatingDayEntity] in de database.
     */
    @Query("SELECT * FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getFoodEntries(): LiveData<List<FoodEntryEntity>>

    /**
     * Gets the amount of calories registered from the last [EatingDayEntity] in the database.
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
    fun getFoodEntry(key: Long): FoodEntryEntity
}