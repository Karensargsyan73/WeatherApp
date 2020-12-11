package com.example.weatherapp.presentation.weekweather

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeekWeatherFragment : Fragment(R.layout.fragment_week_weather) {
    private val viewModel: WeekWeatherViewModel by viewModels()

}