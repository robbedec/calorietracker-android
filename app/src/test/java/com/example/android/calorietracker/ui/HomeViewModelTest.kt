package com.example.android.calorietracker.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.android.calorietracker.data.room.entities.EatingDay
import com.example.android.calorietracker.data.room.entities.EatingDayWithEntries
import com.example.android.calorietracker.data.room.entities.FoodEntry
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import com.example.android.calorietracker.utils.CoroutinesTestRule
import com.example.android.calorietracker.utils.getValueForTest
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    private val repo = mockk<FoodRepository>()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    var instantTestExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        coEvery { repo.getAmountCalories() } returns MutableLiveData(500)
        coEvery {repo.getLimitCalories() } returns MutableLiveData(5000)
        coEvery { repo.getFoodEntries() } returns MutableLiveData(listOf())
        coEvery { repo.getToday() } returns EatingDayWithEntries(EatingDay(1), listOf())
        viewModel = HomeViewModel(repo)
    }

    @After
    fun destroy() {
        clearMocks(repo)
    }

    @Test
    fun homeViewModel_AddEntry_Manual() {
        coEvery { repo.getAmountCalories() } returns MutableLiveData(500)
        coEvery { repo.insertFoodEntry(any()) } returns Unit

        runBlockingTest {
            viewModel.addEntry("banana", 40)
        }

        coVerify { repo.insertFoodEntry(any()) }
    }

    @Test
    fun homeViewModel_ClickEntry_ContainsApiId() {
        coEvery { repo.getFoodEntry(any()) } returns FoodEntry(1, apiId = "123")

        runBlockingTest {
            viewModel.onFoodEntryClicked(1, 0)
        }

        assertNotNull(viewModel.navigateToFoodEntryOverview.getValueForTest()!!)
        assertNull(viewModel.showErrorAlert.getValueForTest())
    }

    @Test
    fun homeViewModel_ClickEntry_DoesNotContainApiId() {
        coEvery { repo.getFoodEntry(any()) } returns FoodEntry(1)

        runBlockingTest {
            viewModel.onFoodEntryClicked(1, 0)
        }

        assertNull(viewModel.navigateToFoodEntryOverview.getValueForTest())
        assertTrue(viewModel.showErrorAlert.getValueForTest()!!)
    }

    @Test
    fun homeViewModel_ClickEntry_Remove() {
        coEvery { repo.removeEntry(any()) } returns Unit

        runBlockingTest {
            viewModel.onFoodEntryClicked(1, 1)
        }

        coVerify { repo.removeEntry(1) }
    }

    @Test
    fun homeViewModel_ClearEntries() {
        coEvery { repo.clearEntries() } returns Unit

        runBlockingTest {
            viewModel.clearEntries()
        }

        assertTrue(viewModel.showSnackbarEvent.getValueForTest()!!)
        coVerify { repo.clearEntries() }
    }
}