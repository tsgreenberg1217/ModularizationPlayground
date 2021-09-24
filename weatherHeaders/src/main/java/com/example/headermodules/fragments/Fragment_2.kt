package com.example.headermodules.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data_utility.DataState
import com.example.data_utility.models.CityWeatherResult
import com.example.headermodules.R
import com.example.headermodules.recyclerViews.WeatherRecyclerViewAdapter
import com.example.headermodules.baseClasses.BaseFragment
import com.example.headermodules.databinding.Fragment2Binding
import com.example.headermodules.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class Fragment_2 : BaseFragment(R.layout.fragment_2) {
    lateinit var binding: Fragment2Binding

    private val weatherViewModel: WeatherViewModel by viewModels()
    lateinit var adapter: WeatherRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = Fragment2Binding.bind(view)
        binding.weatherRV.layoutManager = LinearLayoutManager(this@Fragment_2.context)
        adapter = WeatherRecyclerViewAdapter(mutableListOf())
        binding.weatherRV.adapter = adapter
        weatherViewModel.cities.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    adapter.updateCities(it.data)
                }
                is DataState.Error -> {
                }
                is DataState.Loading -> {
                }
                else -> {
                }
            }
        }
        weatherViewModel.getAllCities()
    }
}