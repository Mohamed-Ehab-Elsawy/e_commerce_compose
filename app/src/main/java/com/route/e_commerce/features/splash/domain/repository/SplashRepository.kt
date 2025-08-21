package com.route.e_commerce.features.splash.domain.repository

import com.route.e_commerce.core.data.entities.UserEntity

interface SplashRepository {
    suspend fun fetchUserEntity(): UserEntity?
}