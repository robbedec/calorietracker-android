package com.example.android.calorietracker

/*
 * An android test uses the android frameworks (so it needs to run on an emulator or real device)
 * Normal unit tests that don't require the android framework should be placed in the provided test package
 */

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.data.room.EatingDayDao
import com.example.android.calorietracker.data.room.FoodEntryDao
import com.example.android.calorietracker.data.room.entities.EatingDayEntity
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class CalorieDatabaseTest {

    private lateinit var eatingDao: EatingDayDao
    private lateinit var foodDao: FoodEntryDao
    private lateinit var db: CalorieDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, CalorieDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        eatingDao = db.eatingDayDao
        foodDao = db.foodEntryDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetDay() {
        val day = EatingDayEntity()
        val entry = FoodEntryEntity()

        eatingDao.insert(day)
        foodDao.insert(entry)

        val testDay = eatingDao.getToday()
        assertEquals(testDay?.eatingDay!!.amountCal, 0)
    }
}
