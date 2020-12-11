package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.entity.WeekWeatherEntity
import com.example.weatherapp.domain.model.WeekWeatherModel

object WeekWeatherMapper {

    fun toDomain(weekWeatherEntity: WeekWeatherEntity): List<WeekWeatherModel> {
        return weekWeatherEntity.dailyWeather.map { weekWeather ->
            val weekWeatherMain = weekWeather.weekWeatherMainEntity.first()

            WeekWeatherModel(
                windSpeed = weekWeather.windSpeed,
                dayTemp = weekWeather.temperature.day.toInt().toString(),
                nightTemp = weekWeather.temperature.night.toInt().toString(),
                eveningTemp = weekWeather.temperature.evening.toInt().toString(),
                morningTemp = weekWeather.temperature.morning.toInt().toString(),
                main = weekWeatherMain.main,
                icon = weekWeatherMain.icon,
                description = weekWeatherMain.description
            )
        }
    }
}