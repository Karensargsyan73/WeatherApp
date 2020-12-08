package com.example.weatherapp.di.activity

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object NavigationModule {
    private val cicerone = Cicerone.create()

    @Provides
    @ActivityRetainedScoped
    fun getRouter(): Router {
        return cicerone.router
    }

    @Provides
    @ActivityRetainedScoped
    fun getNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}