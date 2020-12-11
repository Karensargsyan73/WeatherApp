package com.example.weatherapp.presentation.dayweather

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDayPagerBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DayPagerFragment : Fragment(R.layout.fragment_day_pager) {
    companion object {
        private const val CITY_KEY = "city"

        fun newInstance(city: String): DayPagerFragment {
            val args = Bundle()
            args.putString(CITY_KEY, city)

            val fragment = DayPagerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val viewModel: DayWeatherViewModel by viewModels()
    private lateinit var binding: FragmentDayPagerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = arguments?.getString(CITY_KEY)

        binding = DataBindingUtil.bind(view)!!

        viewModel.loadCity(city)

        viewModel.showWeather.observe(viewLifecycleOwner) { weather ->
            binding.tempId.text = weather.temp.toInt().toString()
            binding.humidityDescriptionId.text = weather.description

            Picasso.get()
                .load(String.format(BuildConfig.ICON_URL, weather.icon))
                .into(binding.iconId)

            binding.weeksTemp.setOnClickListener { viewModel.onWeeksTempClick(weather) }
        }
    }
}
