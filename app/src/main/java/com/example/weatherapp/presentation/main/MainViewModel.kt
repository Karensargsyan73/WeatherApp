package com.example.weatherapp.presentation.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel @ViewModelInject constructor(
    router: Router
) : ViewModel() {
    init {
        router.newRootScreen(Screens.chooseCity())
    }
}