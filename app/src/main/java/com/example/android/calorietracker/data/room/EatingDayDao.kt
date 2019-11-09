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

    @Update
    fun update(entry: FoodEntry)

    @Delete
    fun delete(entry: EatingDay)

    @Delete
    fun delete(entry: FoodEntry)

    /**
     * Get day by id
     */
    @Query("SELECT * FROM daily_eating_table WHERE dayId = :key")
    fun get(key: Long): EatingDay

    /**
     * Remove all records from the database
     */
    @Query("DELETE FROM daily_eating_table")
    fun clear()

    /**
     * Remove all food entries from the database
     */
    @Query("DELETE FROM food_entry_table WHERE ownerId = :key")
    fun clearEntries(key: Long)

    /**
     * Get all day records from the table
     * Automatically updates the live data when changes are recorded in the database
     */
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC")
    fun getAllEntries(): LiveData<List<EatingDay>>

    // TODO: Change to inner join and display all properties from currentday
    /**
     * Returns the latest record in the table
     * Nullable in case there are no records in the table (after clearing table ...)
     * Includes all entries for that day
     */
    @Transaction
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getToday(): EatingDayWithEntries?

    /**
     * Gets a list of [FoodEntry] from the last [EatingDay] in the database
     */
    @Query("SELECT * FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getFoodEntries(): LiveData<List<FoodEntry>>

    /**
     * Gets the amount of calories registered from the last [EatingDay] in the database
     */
    @Query("SELECT SUM(food_amount_calories) FROM food_entry_table WHERE ownerId = (SELECT dayId FROM daily_eating_table ORDER BY dayId DESC LIMIT 1) ORDER BY entryId DESC")
    fun getAmountCalories(): LiveData<Int>

    /**
     * Gets the calorie intake limit from the last [EatingDay] in the database
     */
    @Query("SELECT limit_calories FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getLimitCalories(): LiveData<Int>
}