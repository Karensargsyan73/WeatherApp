package com.example.weatherapp.presentation.dayweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecase.WeatherUseCase
import com.github.terrakok.cicerone.Router

class DayWeatherViewModel @ViewModelInject constructor(
    private val useCase: WeatherUseCase,
    private val router: Router
) : ViewModel() {
}