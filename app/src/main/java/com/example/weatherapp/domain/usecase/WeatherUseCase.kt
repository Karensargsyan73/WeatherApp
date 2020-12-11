package com.example.weatherapp.domain.usecase

import android.content.SharedPreferences
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.model.WeekWeatherModel
import io.reactivex.rxjava3.core.Single
import java.lang.ref.SoftReference
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    fun getWeekWeatherInformation(lat: Double, lon: Double): Single<List<WeekWeatherModel>> {
        return repository.getWeekWeatherInformation(lat, lon)
    }

    fun getFirstWeatherInformation(city: String): Single<WeatherModel> {
        return repository.getFirstWeatherInformation(city)
    }

    fun getWeatherInformation(city: String): Single<WeatherModel> {
        return repository.getWeatherInformation(city)
    }

    fun isHavingCity(): Boolean {
        return repository.isHaveCity()
    }

    fun getCities(): String {
        return repository.getCities()
    }
}