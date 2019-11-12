package com.example.android.calorietracker.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Presents two ways for getting the value from a [LiveData] object during tests
 */

fun <T> LiveData<T>.observeForTesting(
    block: () -> Unit) {
    val observer = Observer<T> { Unit }
    try {
        observeForever(observer)
        block()
    } finally {
        removeObserver(observer)
    }
}

fun <T> LiveData<T>.getValueForTest(): T? {
    var value: T? = null
    val observer = Observer<T> {
        value = it
    }
    observeForever(observer)
    removeObserver(observer)
    return value
}