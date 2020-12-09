package com.example.weatherapp.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WeekWeatherModel(
    val cityName: String,
    val humidity: String,
    val windSpeed: String,
    val dayTemp: String,
    val nightTemp: String,
    val eveningTemp: String,
    val morningTemp: String,
    val main: String,
    val description: String,
    val icon: String
) : Serializable {
}