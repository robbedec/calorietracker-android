package com.example.android.calorietracker.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.android.calorietracker.R
import com.example.android.calorietracker.databinding.FragmentHomeBinding
import com.example.android.calorietracker.ui.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate xml in onCreateView
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)

        // Request the ViewModal
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.homeViewModal = viewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }


}
