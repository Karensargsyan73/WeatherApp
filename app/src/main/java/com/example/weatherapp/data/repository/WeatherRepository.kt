package com.example.weatherapp.data.repository

import android.content.SharedPreferences
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.source.remote.Api
import com.example.weatherapp.data.mapper.WeatherMapper
import com.example.weatherapp.data.mapper.WeekWeatherMapper
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.model.WeekWeatherModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Query
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: Api,
    private val preferences: SharedPreferences
) {
    private companion object {
        const val CITIES_KEY = "cities"
    }

    fun getFirstWeatherInformation(city: String): Single<WeatherModel> {
        return api.getWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeatherMapper.toDomain(it) }
            .doAfterSuccess {
                var cities = preferences.getString(CITIES_KEY, "") ?: ""
                cities += "," + it.cityName
                preferences.edit().putString(CITIES_KEY, cities).apply()
            }
    }

    fun getWeatherInformation(city: String): Single<WeatherModel> {
        return api.getWeatherInformation(city, BuildConfig.API_KEY)
            .map { WeatherMapper.toDomain(it) }
    }

    fun getWeekWeatherInformation(lat: Double, lon: Double): Single<List<WeekWeatherModel>> {
        return api.getWeekWeatherInformation(lat, lon, BuildConfig.API_KEY)
            .map { WeekWeatherMapper.toDomain(it) }
    }

    fun isHaveCity(): Boolean {
        return preferences.getString(CITIES_KEY, null) != null
    }

    fun getCities(): String {
        return preferences.getString(CITIES_KEY, null) ?: ""
    }
}