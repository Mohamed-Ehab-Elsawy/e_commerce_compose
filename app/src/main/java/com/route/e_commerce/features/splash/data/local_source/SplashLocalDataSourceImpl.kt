package com.route.e_commerce.features.splash.data.local_source

import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.core.data.store.DataStoreManager
import kotlinx.coroutines.flow.firstOrNull

class SplashLocalDataSourceImpl(
    private val dataStoreManager: DataStoreManager
) : SplashLocalDataSource {
    override suspend fun fetchUserEntity(): UserEntity? =
        dataStoreManager.fetchUser().firstOrNull()
}