package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

class WeatherEntity(
    @SerializedName("coord")
    val cityCoordinatesEntity: CityCoordinatesEntity,
    @SerializedName("weather")
    val weatherMainEntity: List<WeatherMainEntity>,
    @SerializedName("main")
    val mainEntity: MainEntity,
    @SerializedName("name")
    val cityNameEntity: String
)

class CityCoordinatesEntity(
    val lon: Double,
    val lat: Double
)

class WeatherMainEntity(
    val main: String,
    val description: String,
    val icon: String
)

class MainEntity(
    val temp: Double,
    val humidity: Int
)