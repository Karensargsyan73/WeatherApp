package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.entity.WeekWeatherEntity
import com.example.weatherapp.domain.model.WeekWeatherModel

object WeekWeatherMapper {

    fun toDomain(weekWeatherEntity: WeekWeatherEntity): WeekWeatherModel {
        val weekWeatherMainEntity = weekWeatherEntity.dailyWeather.weekWeatherMainEntity.first()
        return WeekWeatherModel(
            cityName = weekWeatherEntity.cityName,
            humidity = weekWeatherEntity.dailyWeather.humidity,
            windSpeed = weekWeatherEntity.dailyWeather.windSpeed,
            dayTemp = weekWeatherEntity.dailyWeather.temperature.day,
            nightTemp = weekWeatherEntity.dailyWeather.temperature.night,
            eveningTemp = weekWeatherEntity.dailyWeather.temperature.evening,
            morningTemp = weekWeatherEntity.dailyWeather.temperature.morning,
            main = weekWeatherMainEntity.main,
            icon = weekWeatherMainEntity.icon,
            description = weekWeatherMainEntity.icon
        )
    }
}