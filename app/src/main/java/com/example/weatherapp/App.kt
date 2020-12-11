package com.example.weatherapp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import zerobranch.androidremotedebugger.AndroidRemoteDebugger

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}