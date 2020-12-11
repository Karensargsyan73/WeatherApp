package com.example.weatherapp.presentation.weekweather

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeekWeatherBinding
import com.example.weatherapp.domain.model.WeatherModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeekWeatherFragment : Fragment(R.layout.fragment_week_weather) {
    companion object {
        private const val WEATHER_KEY = "weather"

        fun newInstance(weather: WeatherModel): WeekWeatherFragment {
            val args = Bundle()
            args.putSerializable(WEATHER_KEY, weather)

            val fragment = WeekWeatherFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val viewModel: WeekWeatherViewModel by viewModels()
    private lateinit var binding: FragmentWeekWeatherBinding
    private var adapter: WeekWeatherAdapter = WeekWeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weather: WeatherModel = arguments?.getSerializable(WEATHER_KEY) as WeatherModel

        viewModel.init(weather)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        viewModel.showWeekWeather.observe(viewLifecycleOwner) { weekWeathers ->
            adapter.update(weekWeathers)
        }

        binding.weeksList.adapter = adapter
        binding.weeksList.layoutManager = LinearLayoutManager(context)
    }
}