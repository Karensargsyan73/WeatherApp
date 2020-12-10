package com.example.weatherapp.presentation.choosecity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecase.WeatherUseCase
import com.example.weatherapp.navigation.Screens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class ChooseCityViewModel @ViewModelInject constructor(
    private val useCase: WeatherUseCase,
    private val router: Router
) : ViewModel() {

    fun onSearchClick(city: String) {
        useCase.getWeatherInformation(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { weatherModel ->
                   router.navigateTo(Screens.dayWeather())
                },
                { th ->
                    th.printStackTrace()
                }
            )
    }
}