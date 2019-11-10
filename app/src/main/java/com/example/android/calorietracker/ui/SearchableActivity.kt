package com.example.android.calorietracker.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.ActivityMainBinding
import com.example.android.calorietracker.databinding.ActivitySearchBinding

// Documentation searchActivity: https://developer.android.com/guide/topics/search/search-dialog
// Documentation progressDialog (spinner): https://developer.android.com/guide/topics/ui/dialogs.html#ProgressDialog

class SearchableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySearchBinding>(this,
            R.layout.activity_search
        )

        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                //doMySearch(query)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the options menu from XML
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        searchItem.expandActionView()

        searchItem.setOnActionExpandListener(object: MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)

                // Never let the actionBar collapse, makes a better return animation
                return false
            }
        })
        return true
    }
}