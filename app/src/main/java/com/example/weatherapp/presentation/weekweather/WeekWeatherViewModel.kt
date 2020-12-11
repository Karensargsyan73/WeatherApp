package com.example.weatherapp.presentation.weekweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.model.WeekWeatherModel
import com.example.weatherapp.domain.usecase.WeatherUseCase
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeekWeatherViewModel @ViewModelInject constructor(
    private val useCase: WeatherUseCase,
    private val router: Router
) : ViewModel() {

    val showWeekWeather = MutableLiveData<List<WeekWeatherModel>>()

    fun init(weather: WeatherModel) {
        useCase.getWeekWeatherInformation(weather.lat, weather.lon)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { weekWeather ->
                    showWeekWeather.value = weekWeather
                },
                { th ->
                    th.printStackTrace()
                }
            )
    }
}