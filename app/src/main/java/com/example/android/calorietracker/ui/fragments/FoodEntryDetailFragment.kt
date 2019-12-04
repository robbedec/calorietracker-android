package com.example.android.calorietracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.FragmentFoodEntryDetailBinding
import com.example.android.calorietracker.ui.MainActivity
import com.example.android.calorietracker.ui.adapters.NutritionAdapter
import com.example.android.calorietracker.ui.viewModels.FoodEntryDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FoodEntryDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodEntryDetailBinding
    private val viewModel: FoodEntryDetailViewModel by viewModel {
        parametersOf(requireArguments().getLong("entryId"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_food_entry_detail, container, false)

        binding.productDetailNutritionList.adapter = NutritionAdapter()

        return binding.root
    }

    /**
     * Initialized when the fragment pops on the screen.
     * Enables the back button and implements the observers.
     */
    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        viewModel.product.observe(viewLifecycleOwner, Observer {
            binding.foodEntry = viewModel.product.value
        })

        viewModel.burnCalories.observe(viewLifecycleOwner, Observer {
            binding.calorieBurnString = viewModel.burnCalories.value
        })
    }

    /**
     * Initialized when moving away from the screen.
     * Disable the back button and deallocate observers to free up unused memory.
     */
    override fun onPause() {
        super.onPause()
        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        //viewModel.product.removeObservers(this)
    }
}