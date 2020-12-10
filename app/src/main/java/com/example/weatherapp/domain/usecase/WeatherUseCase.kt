package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.model.WeatherModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    fun getWeatherInformation(city: String): Single<WeatherModel> {
        return repository.getWeatherInformation(city)
    }
}