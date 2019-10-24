package com.example.android.calorietracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        // One time initializations, layout inflation
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        // prevent nav gesture if not on start destination (swipe only)
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if(nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        NavigationUI.setupWithNavController(binding.navView, navController)

        Timber.i("OnCreate called")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    // Lifecycle methods
    override fun onStart() {
        // Start objects that only run when activity is on screen
        super.onStart()
        Timber.i("onStart called")
    }

    override fun onResume() {
        // Activity gains focus
        super.onResume()
        Timber.i("onResume called")
    }

    override fun onPause() {
        // Activity loses focus -> (blocks UI drawing, so keep light)
        super.onPause()
        Timber.i("onPause called")
    }

    override fun onStop() {
        // Stop objects that only run when activity is on screen; permanently save data
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onDestroy() {
        // Final teardown
        super.onDestroy()
        Timber.i("onDestroy called")
    }

    override fun onRestart() {
        // Anything that runs only if nog being created
        super.onRestart()
        Timber.i("onRestart called")
    }
}
