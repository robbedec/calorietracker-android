package com.example.android.calorietracker

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.example.android.calorietracker.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
@LargeTest
class DefaultTextValuesTest {


    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.clear_entries_text)).perform(click())
    }

    @Test
    fun testDefaultProgressText() {
        val defaultProgress = "0 / 5000"
        val defaultPercentage = "0%"

        onView(withId(R.id.progress_text)).check(matches(withText(defaultProgress)))
        onView(withId(R.id.percentage_text)).check(matches(withText(defaultPercentage)))
    }

    @Test
    fun testSnackbarShowOnClearingEntries() {
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.cleared_message)))
    }


    @Test
    fun testTextValuesAfterNewEntry() {
        val percentage = "30%"

        // Wait for the snackbar to stop showing
        SystemClock.sleep(3100)

        for(x in 0..2) {
            onView(withId(R.id.add_button)).perform(click())
            onView(withText("From favorites")).inRoot(RootMatchers.isDialog()).perform(click())
        }

        onView(withId(R.id.percentage_text)).check(matches(withText(percentage)))
    }
}