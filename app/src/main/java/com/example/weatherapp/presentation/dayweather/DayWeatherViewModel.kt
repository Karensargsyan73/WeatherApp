package com.example.weatherapp.presentation.dayweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.usecase.WeatherUseCase
import com.example.weatherapp.navigation.Screens
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class DayWeatherViewModel @ViewModelInject constructor(
    private val useCase: WeatherUseCase,
    private val router: Router
) : ViewModel() {
    val showCityPages = MutableLiveData<List<String>>()
    val showWeather = MutableLiveData<WeatherModel>()

    init {
        val cities = useCase.getCities()
            .split(",")
            .toList()
            .filter { it.isNotBlank() }

        showCityPages.value = cities
    }

    fun loadCity(city: String?) {
        if (city == null) {
            return
        }

        useCase.getWeatherInformation(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { weather ->
                    showWeather.value = weather
                },
                { th ->
                    th.printStackTrace()
                }
            )
    }

    fun onAddCityClick() {
        router.navigateTo(Screens.chooseCity())
    }

    fun onWeeksTempClick(weather: WeatherModel) {
        router.navigateTo(Screens.weekWeather(weather))
    }
}