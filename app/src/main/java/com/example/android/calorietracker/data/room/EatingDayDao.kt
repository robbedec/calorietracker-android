package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.calorietracker.data.models.EatingDay
import com.example.android.calorietracker.data.models.EatingDayWithEntries
import com.example.android.calorietracker.data.models.FoodEntry

@Dao
interface EatingDayDao {

    @Insert
    fun insert(entry: EatingDay)

    /*@Insert
    fun insertFoodEntry(entry: FoodEntry)*/

    @Update
    fun update(entry: EatingDay)

    @Delete
    fun delete(entry: EatingDay)

    /*
     * Get day by id
     */
    @Query("SELECT * FROM daily_eating_table WHERE dayId = :key")
    fun get(key: Long): EatingDay

    /*
     * Remove all records from the table
     */
    @Query("DELETE FROM daily_eating_table")
    fun clear()

    /*
     * Get all day records from the table
     * Automatically updates the live data when changes are recorded in the database
     */
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC")
    fun getAllEntries(): LiveData<List<EatingDay>>

    /*
     * Returns the latest record in the table
     * Nullable in case there are no records in the table (after clearing table ...)
     * Includes all entries for that day
     */
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getToday(): EatingDayWithEntries?
}