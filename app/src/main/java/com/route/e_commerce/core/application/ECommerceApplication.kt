package com.route.e_commerce.core.application

import android.app.Application
import com.route.e_commerce.core.di.apisModule
import com.route.e_commerce.core.di.dataStoreModule
import com.route.e_commerce.core.di.localDataSourcesModule
import com.route.e_commerce.core.di.remoteDataSourcesModule
import com.route.e_commerce.core.di.repositoriesModule
import com.route.e_commerce.core.di.retrofitModule
import com.route.e_commerce.core.di.useCasesModule
import com.route.e_commerce.core.di.viewModelsModule
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
                retrofitModule,
                apisModule,
                dataStoreModule,
                viewModelsModule,
                remoteDataSourcesModule,
                localDataSourcesModule,
                repositoriesModule,
                useCasesModule
            )
        }
    }
}