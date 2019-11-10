package com.example.android.calorietracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.calorietracker.databinding.FragmentSearchBinding
import com.example.android.calorietracker.ui.adapters.SearchResultAdapter
import com.example.android.calorietracker.ui.viewModels.SearchViewModel

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

        return binding.root
    }
}