package com.example.android.calorietracker.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.calorietracker.R
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.databinding.FragmentHomeBinding
import com.example.android.calorietracker.ui.adapters.FoodEntryAdapter
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import com.example.android.calorietracker.utils.BaseCommand
import com.example.android.calorietracker.utils.HomeViewModelFactory
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate xml in onCreateView
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)

        // Request the ViewModal
        val application = requireNotNull(this.activity).application
        val dataSource = CalorieDatabase.getInstance(application).eatingDayDao
        val viewModelFactory = HomeViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.homeViewModal = viewModel

        // Fill the recyclerview
        val adapter = FoodEntryAdapter()
        binding.entryList.adapter = adapter


        // Specify a lifecycle owner to define the scope of the LiveData object, binding can observe live data changes
        binding.lifecycleOwner = this

        binding.addButton.setOnClickListener {
            val listItems = viewModel.dialogList
            val mBuilder = AlertDialog.Builder(this.context!!)
            mBuilder.setTitle("Where do you want to search?")
            mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
                viewModel.addCalories(i)
                dialogInterface.dismiss()
            }
            // Set the neutral/cancel button click listener
            mBuilder.setNeutralButton("Cancel") { dialog, _ ->
                // Do something when the neutral button is clicked
                dialog.cancel()
            }

            val mDialog = mBuilder.create()
            mDialog.show()
        }

        /*
         * Update the recyclerview when the contents of the viewmodel list changes
         */
        viewModel.entries.observe(viewLifecycleOwner, Observer {
            it?.let {
                // Default listAdapter method
                adapter.submitList(it)
            }
        })

        /*
         * Observe state and navigate to the right screen
         */
        viewModel.addFromState.observe(this, Observer {
            when(it) {
                is BaseCommand.ApiSearch -> {
                    // TODO: navigate
                    Timber.i("Value change observed!")
                }
                is BaseCommand.Manual -> {
                    // TODO: navigate
                }
                is BaseCommand.Favorites -> {
                    // TODO: navigate
                }
            }
        })

        /*
         * Show snackbar when the entries get cleared
         */
        viewModel.showSnackbarEvent.observe(this, Observer {
            if(it) {
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.cleared_message),
                    Snackbar.LENGTH_LONG
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })

        return binding.root
    }
}
