package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

class WeekWeatherEntity(
    @SerializedName("daily")
    val dailyWeather: List<DailyWeather>
)

class DailyWeather(
    @SerializedName("temp")
    val temperature: Temperature,
    @SerializedName("wind_speed")
    val windSpeed: String,
    @SerializedName("weather")
    val weekWeatherMainEntity: List<WeekWeatherMainEntity>
)

class Temperature(
    @SerializedName("day")
    val day: Double,
    @SerializedName("night")
    val night: Double,
    @SerializedName("eve")
    val evening: Double,
    @SerializedName("morn")
    val morning: Double
)

class WeekWeatherMainEntity(
    val main: String,
    val description: String,
    val icon: String
)