package com.example.android.calorietracker.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.calorietracker.data.room.entities.EatingDayEntity
import com.example.android.calorietracker.data.room.entities.FoodEntryEntity

/**
 * Version needs to increment each time the database schema changes, this creates a versioning system to log schema changes.
 * To disable versioning use: exportSchema = false.
 *
 * Contains a static method that returns an instance for the provided context.
 *
 * @author Robbe Decorte
 */
@Database(entities = [EatingDayEntity::class, FoodEntryEntity::class], version = 2, exportSchema = false)
abstract class CalorieDatabase : RoomDatabase() {

    abstract val eatingDayDao: EatingDayDao
    abstract val foodEntryDao: FoodEntryDao


    // Allows clients to access methods to create or get the database without instantiating the class
    companion object {


        // @Volatile: value will never be cached, in other words: always up to date
        // Used for multithreading
        @Volatile
        private var INSTANCE: CalorieDatabase? = null

        /**
         * Claims exclusive access to the context and provides an instance (singleton) of the database.
         * Initialize the singleton if the current value of the instance is null.
         *
         * @param context contains global information about the application.
         * @return an instance of the database.
         */
        fun getInstance(context: Context): CalorieDatabase {

            // Multithreading lock, this = access to the context
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, CalorieDatabase::class.java, "calorie_history_database")
                        .fallbackToDestructiveMigration() // Migration to a new database scheme
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}