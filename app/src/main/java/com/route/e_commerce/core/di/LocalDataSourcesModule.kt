package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.login.data.sources.local.LoginLocalDataSource
import com.route.e_commerce.features.auth.login.data.sources.local.LoginLocalDataSourceImpl
import com.route.e_commerce.features.auth.signup.data.sources.local.SignupLocalDataSource
import com.route.e_commerce.features.auth.signup.data.sources.local.SignupLocalDataSourceImpl
import com.route.e_commerce.features.main.presentation.views.home.data.sources.local.HomeLocalDataSource
import com.route.e_commerce.features.main.presentation.views.home.data.sources.local.HomeLocalDataSourceImpl
import com.route.e_commerce.features.splash.data.local_source.SplashLocalDataSource
import com.route.e_commerce.features.splash.data.local_source.SplashLocalDataSourceImpl
import org.koin.dsl.module

val localDataSourcesModule = module {

    single<SplashLocalDataSource> {
        SplashLocalDataSourceImpl(get())
    }

    single<SignupLocalDataSource> {
        SignupLocalDataSourceImpl(get())
    }

    single<LoginLocalDataSource> {
        LoginLocalDataSourceImpl(get())
    }

    single<HomeLocalDataSource> {
        HomeLocalDataSourceImpl(get())
    }

}