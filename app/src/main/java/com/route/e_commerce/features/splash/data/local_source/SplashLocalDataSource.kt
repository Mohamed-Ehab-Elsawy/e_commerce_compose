package com.route.e_commerce.features.splash.data.local_source

import com.route.e_commerce.core.data.entities.UserEntity

interface SplashLocalDataSource {
    suspend fun fetchUserEntity(): UserEntity?
}