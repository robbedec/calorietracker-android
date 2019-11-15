package com.example.android.calorietracker.domain

import android.net.ConnectivityManager
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import com.example.android.calorietracker.data.network.CalorieTrackerApiService
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.data.room.FoodEntryDao
import com.example.android.calorietracker.data.room.entities.EatingDayEntity
import com.example.android.calorietracker.data.room.entities.EatingDayWithEntries
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Repository for fetching data from the database or API.
 *
 * @param database Intsance of the in memory database.
 */
class FoodRepository(private val database: CalorieDatabase, private val apiService: CalorieTrackerApiService, private val connectivityManager: ConnectivityManager) {

    private var eatingDayDao: EatingDayDao = database.eatingDayDao
    private var foodEntryDao: FoodEntryDao = database.foodEntryDao


    /*
     * EatingDay methods
     */
    private suspend fun insertEatingDay(day: EatingDayEntity) {
        withContext(Dispatchers.IO) {
            eatingDayDao.insert(day)
        }
    }

    suspend fun getToday(): EatingDayWithEntries? {
        return withContext(Dispatchers.IO) {
            var day = eatingDayDao.getToday()
            if(day == null) {
                    val newDay = EatingDayEntity()
                    newDay.date = Calendar.getInstance().time
                    insertEatingDay(newDay)
                    day = getToday()
            }
            else if(!DateUtils.isToday(day?.eatingDay?.date!!.time)){
                // Check if the latest date in the database is from today
                    val newDay = EatingDayEntity()
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

    suspend fun insertFoodEntry(entry: FoodEntryEntity) {
        withContext(Dispatchers.IO) {
            foodEntryDao.insert(entry)
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

    fun getFoodEntries(): LiveData<List<FoodEntryEntity>> {
        return foodEntryDao.getFoodEntries()
    }

    fun getAmountCalories(): LiveData<Int> {
        return foodEntryDao.getAmountCalories()
    }

    fun getFoodEntry(key: Long): FoodEntryEntity {
        return foodEntryDao.getFoodEntry(key)
    }
}