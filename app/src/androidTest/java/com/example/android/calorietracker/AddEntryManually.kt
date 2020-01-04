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
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
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
class AddEntryManually {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addEntryManually() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(340)

        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        onView(withText(R.string.clear_entries_text)).perform(click())

        SystemClock.sleep(3000)

        val floatingActionButton = onView(
            withId(R.id.add_button)
        )
        floatingActionButton.perform(click())

        SystemClock.sleep(2000)

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
            .atPosition(1)
        appCompatCheckedTextView.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.dialog_entry_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.dialog_entry_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("pizza"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.dialog_entry_amount),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.dialog_entry_amount),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("500"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton.perform(scrollTo(), click())

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

        SystemClock.sleep(1000)

        val appCompatButton2 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton2.perform(scrollTo(), click())

        val floatingActionButton2 = onView(
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
        floatingActionButton2.perform(click())

        val appCompatCheckedTextView2 = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.select_dialog_listview),
                    childAtPosition(
                        withId(R.id.contentPanel),
                        0
                    )
                )
            )
            .atPosition(1)
        appCompatCheckedTextView2.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.dialog_entry_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(click())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.dialog_entry_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("poffertjes"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.dialog_entry_amount),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(click())

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.dialog_entry_amount),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.custom),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText8.perform(replaceText("150"), closeSoftKeyboard())

        val appCompatButton3 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton3.perform(scrollTo(), click())

        val appCompatButton4 = onView(
            withIndex(withId(R.id.remove_button), 1)
        )

        SystemClock.sleep(1000)

        appCompatButton4.perform(click())

        SystemClock.sleep(1000)

        val textView3 = onView(
            allOf(
                withId(R.id.progress_text), withText("150 / 5000"),
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
        textView3.check(matches(withText("150 / 5000")))

        val textView4 = onView(
                withId(R.id.percentage_text)
        )
        textView4.check(matches(withText("3%")))

        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        onView(withText(R.string.clear_entries_text)).perform(click())
    }

    private fun withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            var currentIndex = 0

            override fun describeTo(description: Description) {
                description.appendText("with index: ")
                description.appendValue(index)
                matcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                return matcher.matches(view) && currentIndex++ == index
            }
        }
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
