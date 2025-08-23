package com.route.e_commerce.core.di

import com.route.e_commerce.core.data.network_manager.NetworkMonitor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { NetworkMonitor(androidContext()) }
}