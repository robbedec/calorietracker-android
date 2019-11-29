package com.example.android.calorietracker.ui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.android.calorietracker.R
import com.example.android.calorietracker.domain.FoodRepository
import com.example.android.calorietracker.data.network.CalorieTrackerApi
import com.example.android.calorietracker.data.room.CalorieDatabase
import com.example.android.calorietracker.databinding.FragmentHomeBinding
import com.example.android.calorietracker.ui.SearchableActivity
import com.example.android.calorietracker.ui.adapters.FoodEntryAdapter
import com.example.android.calorietracker.ui.adapters.FoodEntryListener
import com.example.android.calorietracker.ui.viewModels.HomeViewModel
import com.example.android.calorietracker.utils.ApplicationViewModelFactory
import com.example.android.calorietracker.utils.BaseCommand
import com.google.android.material.snackbar.Snackbar

/**
 * Fragment shows the main page of the app.
 *
 * @author Robbe Decorte
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: FoodEntryAdapter

    /**
     * Inflates the layout with Data Binding and sets the lifecycle owner to the [HomeFragment] to enable Data Binding and observe [LiveData].
     * Sets up the [RecyclerView] with an adapter.
     *
     * @param inflater Inflates the layout.
     * @param container
     * @param savedInstanceState Previously saved view state.
     * @return The view that is displayed in the fragment.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate xml in onCreateView
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)

        setHasOptionsMenu(true)

        // Request the ViewModal
        val application = requireNotNull(this.activity).application

        val database = CalorieDatabase.getInstance(application)
        val apiService = CalorieTrackerApi.retrofitService

        val viewModelFactory = ApplicationViewModelFactory(
            FoodRepository(
                database,
                apiService
            )
        )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        binding.homeViewModal = viewModel

        // Fill the recyclerview and trigger navigation when an item is clicked
        adapter = FoodEntryAdapter(FoodEntryListener {
            foodEntryId: Long, action: Int ->  viewModel.onFoodEntryClicked(foodEntryId, action)
        })
        binding.entryList.adapter = adapter

        // Specify a lifecycle owner to define the scope of the LiveData object, binding can observe live data changes
        binding.lifecycleOwner = this

        binding.addButton.setOnClickListener {
            createEntrySourceDialog()
        }

        return binding.root
    }

    /**
     * Inflates the overflow menu
     *
     * @param menu [Menu] that contains the overflow menu.
     * @param inflater The [MenuInflater].
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Checks which item of the overflow menu was selected and triggers the action in [HomeViewModel].
     *
     * @param item The item that was clicked.
     * @return true if the overflow menu should close after clicking an item.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.clear_entries_menu -> viewModel.clearEntries()
        }
        return true
    }

    override fun onResume() {
        super.onResume()

        /**
         * Update the [RecyclerView] when the contents of the viewmodel list changes
         *
         * Can't use the Generic bindingAdapter because of the custom header
         */
        viewModel.entries.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        /**
         * Observe state and navigate to the right screen
         */
        viewModel.addFromState.observe(this, Observer {
            when(it) {
                is BaseCommand.ApiSearch -> {
                    // Navigate to Search activity
                    val intent = Intent(activity, SearchableActivity::class.java)
                    activity!!.startActivity(intent)
                }
                is BaseCommand.Manual -> {
                    createAddDialog()
                }
                is BaseCommand.Favorites -> {
                    // TODO: navigate
                }
            }
        })

        /**
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


        viewModel.navigateToFoodEntryOverview.observe(this, Observer { entry ->
            entry?.let {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFoodEntryDetailFragment(entry))
                viewModel.onFoodEntryNavigated()
            }
        })
    }

    /**
     * Deallocate the observers when the fragment is not displayed on screen.
     */
    override fun onPause() {
        super.onPause()

        viewModel.entries.removeObservers(this)
        viewModel.addFromState.removeObservers(this)
        viewModel.showSnackbarEvent.removeObservers(this)
        viewModel.navigateToFoodEntryOverview.removeObservers(this)
    }

    /**
     * Create and display a dialog where the uses can select from which source they want to add a new entry.
     */
    private fun createEntrySourceDialog() {
        val listItems = viewModel.dialogList
        val mBuilder = AlertDialog.Builder(this.context!!)
        mBuilder.setTitle("Where do you want to search?")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
            viewModel.addCaloriesSource(i)
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

    /**
     * Create a dialog where the uses can enter a new entry manually.
     * Contains the name and the amount of calories.
     */
    private fun createAddDialog() {
        val builder = AlertDialog.Builder(this.context!!)
        val inflater = layoutInflater
        builder.setTitle("Manually add an entry")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_edittext, null)
        builder.setView(dialogLayout)

        val dialogEntryName = dialogLayout.findViewById<EditText>(R.id.dialog_entry_name)
        val dialogEntryAmount = dialogLayout.findViewById<EditText>(R.id.dialog_entry_amount)

        builder.setPositiveButton("OK") { dialogInterface, _ ->
            viewModel.addEntry(dialogEntryName.text.toString().capitalize(), dialogEntryAmount.text.toString().toInt())
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel") { dialogInterface, _ ->
            // Do something when the neutral button is clicked
            dialogInterface.cancel()
        }
        builder.show()
    }
}
