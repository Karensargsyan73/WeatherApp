package com.example.weatherapp.presentation.choosecity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecase.WeatherUseCase

class ChooseCityViewModel @ViewModelInject constructor(
    private val useCase: WeatherUseCase
): ViewModel() {

    fun onSearchClick(city: String) {
        useCase.getWeatherInformation(city)
            .subscribe(
                { weatherModel ->

                },
                { th ->
                    th.printStackTrace()
                }
            )
    }
}