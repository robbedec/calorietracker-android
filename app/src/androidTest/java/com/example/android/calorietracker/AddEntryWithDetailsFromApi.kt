package com.example.android.calorietracker


import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.android.calorietracker.ui.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AddEntryWithDetailsFromApi {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addEntryWithDetailsFromApi() {
        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        onView(withText(R.string.clear_entries_text)).perform(click())

        SystemClock.sleep(3000)

        val floatingActionButton = onView(
            allOf(
                withId(R.id.add_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.myNavHostFragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatCheckedTextView = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.select_dialog_listview),
                    childAtPosition(
                        withId(R.id.contentPanel),
                        0
                    )
                )
            )
            .atPosition(0)
        appCompatCheckedTextView.perform(click())

        val searchAutoComplete = onView(
            allOf(
                withId(R.id.search_src_text),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete.perform(replaceText("big mac"), closeSoftKeyboard())

        SystemClock.sleep(5000)

        val constraintLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.result_list),
                        childAtPosition(
                            withId(R.id.searchFragment),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        constraintLayout.perform(click())

        val viewGroup = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.entry_list),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.progress_text), withText("540 / 5000"),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("540 / 5000")))

        val textView2 = onView(
            allOf(
                withId(R.id.percentage_text), withText("10%"),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("10%")))

        val textView3 = onView(
            allOf(
                withId(R.id.percentage_text), withText("10%"),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("10%")))

        val cardView = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.entry_list),
                        childAtPosition(
                            withId(R.id.titleConstraint),
                            3
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        SystemClock.sleep(5000)

        val textView4 = onView(
            allOf(
                withId(R.id.product_detail_name), withText("Big Mac"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.myNavHostFragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(isDisplayed()))

        val textView5 = onView(
            allOf(
                withText("Cycling takes 73 minutes \n\nRunning takes 44 minutes \n\nWalking takes 126 minutes \n\n"),
                childAtPosition(
                    allOf(
                        withId(R.id.calorie_burning_holder),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            6
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withText("Cycling takes 73 minutes \n\nRunning takes 44 minutes \n\nWalking takes 126 minutes \n\n"),
                childAtPosition(
                    allOf(
                        withId(R.id.calorie_burning_holder),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            6
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(isDisplayed()))

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(R.id.action_bar),
                        childAtPosition(
                            withId(R.id.action_bar_container),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val appCompatButton = onView(
            allOf(
                withId(R.id.remove_button), withText("remove"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val textView7 = onView(
            allOf(
                withId(R.id.percentage_text), withText("0%"),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("0%")))

        val textView8 = onView(
            allOf(
                withId(R.id.progress_text), withText("0 / 5000"),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("0 / 5000")))

        val recyclerView = onView(
            allOf(
                withId(R.id.entry_list),
                childAtPosition(
                    allOf(
                        withId(R.id.titleConstraint),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
