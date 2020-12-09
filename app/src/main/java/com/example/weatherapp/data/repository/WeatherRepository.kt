package com.example.weatherapp.data.repository

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.source.remote.Api
import com.example.weatherapp.data.mapper.WeatherMapper
import com.example.weatherapp.data.mapper.WeekWeatherMapper
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.model.WeekWeatherModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: Api) {

    fun getWeatherInformation(city: String): Single<WeatherModel> {
        return api.getWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeatherMapper.toDomain(it) }
    }

    fun getWeekWeatherInformation(city: String): Single<WeekWeatherModel> {
        return api.getWeekWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeekWeatherMapper.toDomain(it) }
    }
}