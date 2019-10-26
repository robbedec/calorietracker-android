package com.example.android.calorietracker.utils

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.models.FoodEntry
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.StringBuilder


fun formatEntries(entries: List<FoodEntry>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        entries.forEach {
            append("<br>")
            append(resources.getString(R.string.card_title))
            append("\t${it.entryName}<br>")
            append(resources.getString(R.string.card_amount))
            append("\t${it.entryCalories}<br>")
        }
    }
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
