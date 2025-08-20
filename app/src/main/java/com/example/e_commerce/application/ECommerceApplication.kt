package com.example.e_commerce.application

import android.app.Application
import com.example.e_commerce.core.di.apisModule
import com.example.e_commerce.core.di.remoteDataSourcesModule
import com.example.e_commerce.core.di.repositoriesModule
import com.example.e_commerce.core.di.retrofitModule
import com.example.e_commerce.core.di.useCasesModule
import com.example.e_commerce.core.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ECommerceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ECommerceApplication)
            androidLogger(Level.ERROR)
            modules(
                remoteDataSourcesModule,
                repositoriesModule,
                useCasesModule,
                viewModelsModule,
                retrofitModule,
                apisModule
            )
        }
    }
}