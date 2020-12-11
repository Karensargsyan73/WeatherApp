package com.example.weatherapp.data.source.remote

import com.example.weatherapp.data.entity.WeatherEntity
import com.example.weatherapp.data.entity.WeekWeatherEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("data/2.5/weather?lang=ru&units=metric")
    fun getWeatherInformation(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
    ): Single<WeatherEntity>

    @GET("data/2.5/onecall?exclude={current,minutely,hourly,alerts}&lang=ru&units=metric")
    fun getWeekWeatherInformation(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): Single<WeekWeatherEntity>
}