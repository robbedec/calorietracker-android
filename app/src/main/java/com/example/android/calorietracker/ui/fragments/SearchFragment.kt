package com.example.android.calorietracker.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.FragmentSearchBinding
import com.example.android.calorietracker.ui.MainActivity
import com.example.android.calorietracker.ui.adapters.SearchResultAdapter
import com.example.android.calorietracker.ui.viewModels.SearchViewModel
import timber.log.Timber

class SearchFragment : Fragment() {

    /**
     * Lazily initialize our [SearchViewModel]
     */
    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    /**
     * Inflate layout with data binding, set the lifecycle owner to enable
     * data binding to observe [LiveData]
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.searchViewModal = viewModel

        // Initialize the SearchResultAdapter
        binding.resultList.adapter = SearchResultAdapter()

        setHasOptionsMenu(true)

        return binding.root
    }

    /**
     * Inflate the searchbox in the actionbar and open it
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val inflater = activity!!.menuInflater
        inflater.inflate(R.menu.menu_main_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        searchItem.expandActionView()

        searchItem.setOnActionExpandListener(object: MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                val intent = Intent(context!!.applicationContext, MainActivity::class.java)
                startActivity(intent)

                // Never let the actionBar collapse, makes a better return animation
                return false
            }
        })

        var searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query!!.isNotEmpty() && query!!.isNotBlank()){
                    viewModel.searchQuery.value = query
                } else {
                    viewModel.searchQuery.value = ""
                }
                Timber.i(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!!.isNotEmpty() && newText!!.isNotBlank()){
                    viewModel.searchQuery.value = newText
                } else {
                    viewModel.searchQuery.value = ""
                }
                Timber.i(newText)
                return false
            }

        })
    }
}