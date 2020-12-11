package com.example.weatherapp.presentation.dayweather

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDayWeatherBinding
import com.example.weatherapp.presentation.choosecity.ChooseCityViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DayWeatherFragment : Fragment(R.layout.fragment_day_weather) {
    private val viewModel: DayWeatherViewModel by viewModels()
    private lateinit var binding: FragmentDayWeatherBinding
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var tabLayoutMediator: TabLayoutMediator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.addCity.setOnClickListener { viewModel.onAddCityClick() }

        viewModel.showCityPages.observe(viewLifecycleOwner) { cities ->
            pagerAdapter = PagerAdapter(cities, this)
            binding.mainPager.adapter = pagerAdapter

            tabLayoutMediator = TabLayoutMediator(binding.tabs, binding.mainPager) { tab, position ->
                    tab.text = cities[position]
                }

            tabLayoutMediator.attach()
        }
    }

    class PagerAdapter(
        private val cities: List<String>,
        fragment: Fragment
    ) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = cities.size

        override fun createFragment(position: Int): Fragment {
            return DayPagerFragment.newInstance(cities[position])
        }
    }
}