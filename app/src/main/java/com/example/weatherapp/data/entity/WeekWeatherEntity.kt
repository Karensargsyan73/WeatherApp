package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

class WeekWeatherEntity(
    @SerializedName("timezone")
    val cityName: String,
    @SerializedName("daily")
    val dailyWeather: DailyWeather,
)

class DailyWeather(
    @SerializedName("temp")
    val temperature: Temperature,
    val humidity: String,
    @SerializedName("wind_speed")
    val windSpeed: String,
    val weekWeatherMainEntity: List<WeekWeatherMainEntity>
)

class Temperature(
    val day: String,
    val night: String,
    @SerializedName("eve")
    val evening: String,
    @SerializedName("morn")
    val morning: String
)

class WeekWeatherMainEntity(
    val main: String,
    val description: String,
    val icon: String
)