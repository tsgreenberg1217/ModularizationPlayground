package com.example.headermodules.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.data_utility.DataState
import com.example.headermodules.baseClasses.BaseFragment
import com.example.headermodules.R
import com.example.headermodules.databinding.Fragment1Binding
import com.example.headermodules.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment_1 : BaseFragment(R.layout.fragment_1) {
    // yet, another random comment, that is edited

    val viewModel: WeatherViewModel by viewModels()
    lateinit var binding: Fragment1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment1Binding.bind(view)
        binding.frag1Btn.setOnClickListener {
            binding.cityTextField.text.toString().also { viewModel.getWeather(it) }
        }

        viewModel.weatherData.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    findNavController().navigate(R.id.action_fragment_1_dest_to_fragment_1_2)
                }
                is DataState.Error -> {
                    Log.d("","")

                }
                is DataState.Loading -> {

                }
            }
        }
    }
}
