package com.example.weatherapp.domain.usecase

import android.content.SharedPreferences
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.model.WeatherModel
import io.reactivex.rxjava3.core.Single
import java.lang.ref.SoftReference
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

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