package com.example.weatherapp.data.repository

import android.content.SharedPreferences
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.source.remote.Api
import com.example.weatherapp.data.mapper.WeatherMapper
import com.example.weatherapp.data.mapper.WeekWeatherMapper
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.model.WeekWeatherModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: Api,
    var preferences: SharedPreferences
) {
    private companion object {
        const val CITIES_KEY = "cities"
    }

    fun getWeatherInformation(city: String): Single<WeatherModel> {
        return api.getWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeatherMapper.toDomain(it) }
            .doAfterSuccess { preferences.edit().putString(CITIES_KEY, it.cityName).apply() }
    }

    fun getWeekWeatherInformation(city: String): Single<WeekWeatherModel> {
        return api.getWeekWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeekWeatherMapper.toDomain(it) }
    }

    fun isHaveCity(): Boolean {
        return preferences.getString(CITIES_KEY, null) != null
    }
}