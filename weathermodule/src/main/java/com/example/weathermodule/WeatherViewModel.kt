package com.example.weathermodule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data_utility.DataState
import com.example.data_utility.models.CityWeatherResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repo: WeatherRepository
) : ViewModel() {
    val weatherData: MutableLiveData<DataState<CityWeatherResult>> = MutableLiveData()

    init {
        viewModelScope.launch {
            repo.getWeatherForCity("Miami").collect {
                weatherData.value = it
            }
        }
    }
}