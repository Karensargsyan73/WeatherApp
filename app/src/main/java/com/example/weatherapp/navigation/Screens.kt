package com.example.weatherapp.navigation

import com.example.weatherapp.presentation.choosecity.ChooseCityFragment
import com.example.weatherapp.presentation.dayweather.DayWeatherFragment
import com.github.terrakok.cicerone.androidx.AppScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun chooseCity(): AppScreen {
        return FragmentScreen("ChooseCity") { ChooseCityFragment() }
    }

    fun dayWeather(): AppScreen {
        return FragmentScreen("DayWeather") { DayWeatherFragment() }
    }
}