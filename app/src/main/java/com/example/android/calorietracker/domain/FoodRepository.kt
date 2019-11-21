package com.example.android.calorietracker.domain

import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import com.example.android.calorietracker.data.network.CalorieTrackerApiService
import com.example.android.calorietracker.data.network.dto.CategoryProperty
import com.example.android.calorietracker.data.network.dto.FoodProperty
import com.example.android.calorietracker.data.network.dto.NutrientInfo
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.data.room.FoodEntryDao
import com.example.android.calorietracker.data.room.entities.*
import com.example.android.calorietracker.utils.asDatabaseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Repository for fetching data from the database or API.
 *
 * @param database Instance of the in memory database.
 */
class FoodRepository(private val database: CalorieDatabase, private val apiService: CalorieTrackerApiService) {

    private var eatingDayDao: EatingDayDao = database.eatingDayDao
    private var foodEntryDao: FoodEntryDao = database.foodEntryDao

    /*
     * EatingDay methods
     */
    private suspend fun insertEatingDay(day: EatingDay) {
        withContext(Dispatchers.IO) {
            eatingDayDao.insert(day)
        }
    }

    suspend fun getToday(): EatingDayWithEntries? {
        return withContext(Dispatchers.IO) {
            var day = eatingDayDao.getToday()
            if(day == null) {
                    val newDay = EatingDay()
                    newDay.date = Calendar.getInstance().time
                    insertEatingDay(newDay)
                    day = getToday()
            }
            else if(!DateUtils.isToday(day?.eatingDay?.date!!.time)){
                // Check if the latest date in the database is from today
                    val newDay = EatingDay()
                    newDay.date = Calendar.getInstance().time
                    insertEatingDay(newDay)
                    day = getToday()
            }
            // Return the correct day
            day
        }
    }

    fun getLimitCalories(): LiveData<Int> {
        return eatingDayDao.getLimitCalories()
    }

    suspend fun clearDays() {
        withContext(Dispatchers.IO) {
            eatingDayDao.clear()
        }
    }

    /*
     * FoodEntry methods
     */

    suspend fun insertFoodEntry(entry: FoodEntry) {
        withContext(Dispatchers.IO) {
            entry.ownerId = getToday()!!.eatingDay!!.dayId
            foodEntryDao.insert(entry)
        }
    }

    suspend fun insertFoodEntryWithNutrients(entry: FoodProperty) {
        withContext(Dispatchers.IO) {
            var nutrientConversion = getNutrientsUtil()
            var entryDB = entry.asDatabaseEntity()
            entryDB.ownerId = getToday()!!.eatingDay!!.dayId

            val id = foodEntryDao.insert(entryDB)

            val nutrients = entry.nutrients.map { nutrient ->
                val nutrientC = nutrientConversion.find { it.attr_id == nutrient.id }
                ClarifiedNutrient(
                    name = nutrientC!!.name,
                    value = nutrient.value,
                    unit = nutrientC.unit,
                    parentId = id
                ) }
            foodEntryDao.insertAllNutrients(nutrients)
        }
    }

    suspend fun removeEntry(key: Long) {
        withContext(Dispatchers.IO) {
            var entry = getFoodEntry(key)
            foodEntryDao.delete(entry)
        }
    }

    suspend fun clearEntries() {
        withContext(Dispatchers.IO) {
            foodEntryDao.clear()
        }
    }

    fun getFoodEntries(): LiveData<List<FoodEntry>> {
        return foodEntryDao.getFoodEntries()
    }

    fun getAmountCalories(): LiveData<Int> {
        return foodEntryDao.getAmountCalories()
    }

    suspend fun getFoodEntry(key: Long): FoodEntry {
        return withContext(Dispatchers.IO) {
            foodEntryDao.getFoodEntry(key)
        }
    }

    suspend fun getNutrientsFromEntry(key: Long): FoodEntryWithNutrients {
        return withContext(Dispatchers.IO) {
            //foodEntryDao.getNutrientsFromEntry(key)
            foodEntryDao.getFoodEntryWithNutrients(key)
        }
    }

    // API calls
    suspend fun search(query: String): CategoryProperty {
        return apiService.getResultsAsync(query, includeCommon = false, includeSelf = false, detailed = true).await()
    }

    suspend fun getNutrientsUtil(): List<NutrientInfo> {
        return apiService.getNutrientInformationAsync().await()
    }



}