package com.route.e_commerce.features.auth.signup.data.sources.local

import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.core.data.store.DataStoreManager

class SignupLocalDataSourceImpl(
    private val dataStoreManager: DataStoreManager,
) : SignupLocalDataSource {
    override suspend fun storeUserData(userEntity: UserEntity?) {
        if (userEntity != null)
            dataStoreManager.saveUser(userEntity)
    }
}