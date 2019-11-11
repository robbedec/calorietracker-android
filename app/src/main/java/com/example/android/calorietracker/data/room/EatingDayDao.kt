package com.example.android.calorietracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.calorietracker.data.room.entities.EatingDayEntity
import com.example.android.calorietracker.data.room.entities.EatingDayWithEntries

/**
 * Collection of database queries.
 *
 * @author Robbe Decorte
 */
@Dao
interface EatingDayDao {

    @Insert
    fun insert(entry: EatingDayEntity)

    @Update
    fun update(entry: EatingDayEntity)

    @Delete
    fun delete(entry: EatingDayEntity)

    /**
     * Get [EatingDayEntity] by id.
     *
     * @param key id of the desired [EatingDayEntity]
     * @return the corresponding [EatingDayEntity]
     */
    @Query("SELECT * FROM daily_eating_table WHERE dayId = :key")
    fun get(key: Long): EatingDayEntity

    /**
     * Remove all records from [EatingDayEntity] table
     */
    @Query("DELETE FROM daily_eating_table")
    fun clear()

    /**
     * Remove all food entries from the database
     *
     * @param key id of the [EatingDayEntity] from who you want to delete the food entries.
     */
    @Query("DELETE FROM food_entry_table WHERE ownerId = :key")
    fun clearEntries(key: Long)

    /**
     * Get all day records from the table
     * Automatically updates the live data when changes are recorded in the database
     *
     * @return a [LiveData] object that holds a list of [EatingDayEntity]
     */
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC")
    fun getAllEntries(): LiveData<List<EatingDayEntity>>

    /**
     * Get the last [EatingDayEntity] and include it's entries.
     * Nullable in case there are no records in the table (after clearing table ...)
     *
     * @return the last [EatingDayWithEntries] in the database.
     */
    @Transaction
    @Query("SELECT * FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getToday(): EatingDayWithEntries?

    /**
     * Gets the calorie intake limit from the last [EatingDayEntity] in the database.
     *
     * @return a [LiveData] object that holds the calorie limit.
     */
    @Query("SELECT limit_calories FROM daily_eating_table ORDER BY dayId DESC LIMIT 1")
    fun getLimitCalories(): LiveData<Int>
}