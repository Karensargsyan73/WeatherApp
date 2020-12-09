package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.entity.WeatherEntity
import com.example.weatherapp.domain.model.WeatherModel

object WeatherMapper {

    fun toDomain (weatherEntity: WeatherEntity): WeatherModel {
        val weather = weatherEntity.weatherMainEntity.first()
        return WeatherModel(
            lon = weatherEntity.cityCoordinatesEntity.lon,
            lat = weatherEntity.cityCoordinatesEntity.lat,
            main = weather.main,
            description = weather.description,
            icon = weather.icon,
            temp = weatherEntity.mainEntity.temp,
            humidity = weatherEntity.mainEntity.humidity
        )
    }
}