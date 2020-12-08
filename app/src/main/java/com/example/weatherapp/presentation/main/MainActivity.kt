package com.example.weatherapp.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val navigator = AppNavigator(this, R.id.container)
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel
    }

    override fun onResumeFragments() {
        navigationHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}