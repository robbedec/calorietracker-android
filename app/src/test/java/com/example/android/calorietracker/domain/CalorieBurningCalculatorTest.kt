package com.example.android.calorietracker.domain

import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test
import timber.log.Timber

class CalorieBurningCalculatorTest {

    private lateinit var calculator: CalorieBurningCalculator

    @Before
    fun setUp() {
        calculator = CalorieBurningCalculator(amountCal = 540)
    }

    @Test
    fun calculator_constructor_defaultWeight() {
        assertEquals(70.0, calculator.weight)
    }

    @Test
    fun calculator_calculate_resultContainsCorrectKeys() {
        val result = calculator.calculate()

        assertTrue(result.keys.containsAll(listOf("running", "cycling", "walking")))
    }

    @Test
    fun calculator_calculate_resultCorrectValues() {
        val result = calculator.calculate()
        Timber.i(result.values.toString())
        assertTrue(result.values.containsAll(listOf(73, 44, 126)))
    }
}