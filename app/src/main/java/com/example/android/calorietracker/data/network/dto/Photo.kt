package com.example.android.calorietracker.data.network.dto

import com.squareup.moshi.Json

data class Photo(
    val thumb: String,
    @Json(name ="highres")val _highres: String? = ""
) {
   val highres = _highres ?: ""
}