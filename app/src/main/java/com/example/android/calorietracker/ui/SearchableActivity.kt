package com.example.android.calorietracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.ActivitySearchBinding

// Documentation searchActivity: https://developer.android.com/guide/topics/search/search-dialog
// Documentation progressDialog (spinner): https://developer.android.com/guide/topics/ui/dialogs.html#ProgressDialog

class SearchableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySearchBinding>(this,
            R.layout.activity_search
        )
    }
}