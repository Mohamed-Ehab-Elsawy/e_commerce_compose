package com.route.e_commerce.features.splash.data.repository

import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.features.splash.data.local_source.SplashLocalDataSource
import com.route.e_commerce.features.splash.domain.repository.SplashRepository

class SplashRepositoryImpl(
    private val localDataSource: SplashLocalDataSource
) : SplashRepository {
    override suspend fun fetchUserEntity(): UserEntity? = localDataSource.fetchUserEntity()
}