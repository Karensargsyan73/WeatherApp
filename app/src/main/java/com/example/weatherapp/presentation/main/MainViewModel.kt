package com.example.weatherapp.presentation.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecase.WeatherUseCase
import com.example.weatherapp.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel @ViewModelInject constructor(
    useCase: WeatherUseCase,
    router: Router
) : ViewModel() {
    init {
        if (useCase.isHavingCity()) {
            router.newRootScreen(Screens.dayWeather())
        } else {
            router.newRootScreen(Screens.chooseCity())
        }
    }


}