package com.example.weathermodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.data_utility.DataState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainWeatherActivity : AppCompatActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_weather)

        viewModel.weatherData.observe(this) {
            when (it) {
                is DataState.Success -> {
                    Log.d("Result Success", it.data.toString())
                }
                is DataState.Error -> {
                    Log.d("Result Error", it.toString())
                }
                DataState.Loading -> {
                    Log.d("Result Loading", "...Loading")
                }
            }
        }
    }
}