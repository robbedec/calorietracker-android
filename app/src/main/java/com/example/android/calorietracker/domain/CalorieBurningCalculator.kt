package com.example.android.calorietracker.domain

import kotlin.math.roundToInt

/**
 * Estimates the amount of time needed (in minutes) to burn an amount of calories.
 * This class calculates running (9.5km/h), cycling (16km/h) and walking (4.8km/h).
 * More information about the formula or exercises can be found [here](https://www.hss.edu/conditions_burning-calories-with-exercise-calculating-estimated-energy-expenditure.asp).
 *
 * @property weight The weight of the person you want to base the calculation on. Defaults to 70kg.
 * @property amountCal The amount of calories that need to be burned.
 */
data class CalorieBurningCalculator(private val weight: Double = 70.0, private val amountCal: Int) {

    companion object {
        private val MET_VALUES = mapOf("cycling" to 6.0, "running" to 10.0, "walking" to 3.5)
    }

    /**
     * Calculates how many minutes it takes to burn the amount of calories.
     *
     * @return map with the exercise and corresponding time.
     */
    fun calculate(): Map<String, Int> {
        val calculationsMap = mutableMapOf<String, Int>()

        for((key, value) in MET_VALUES) {
            calculationsMap[key] = (amountCal / (0.0175 * value * weight)).roundToInt()
        }
        return calculationsMap
    }
}