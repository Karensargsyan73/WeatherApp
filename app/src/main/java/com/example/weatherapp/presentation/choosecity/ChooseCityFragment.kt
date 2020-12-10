package com.example.weatherapp.presentation.choosecity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ChooseCityLayoutBinding

class ChooseCityFragment : Fragment(R.layout.choose_city_layout) {
    private val chooseCityViewModel: ChooseCityViewModel by viewModels()
    private lateinit var binding: ChooseCityLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }
}