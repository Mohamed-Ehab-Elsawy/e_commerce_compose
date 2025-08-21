package com.route.e_commerce.features.auth.login.data.sources.local

import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.core.data.store.DataStoreManager

class LoginLocalDataSourceImpl(
    private val dataStoreManager: DataStoreManager,
) : LoginLocalDataSource {
    override suspend fun storeUserData(userEntity: UserEntity?) {
        if (userEntity != null)
            dataStoreManager.saveUser(userEntity)
    }
}