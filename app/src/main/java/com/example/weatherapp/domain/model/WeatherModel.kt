package com.example.weatherapp.domain.model

import java.io.Serializable

class WeatherModel(
    val lon: Double,
    val lat: Double,
    val main: String,
    val description: String,
    val icon: String,
    val temp: Int,
    val humidity: Int
) : Serializable