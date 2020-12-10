package com.example.weatherapp.navigation

import com.example.weatherapp.presentation.choosecity.ChooseCityFragment
import com.github.terrakok.cicerone.androidx.AppScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun chooseCity(): AppScreen {
        return FragmentScreen("") { ChooseCityFragment() }
    }
}