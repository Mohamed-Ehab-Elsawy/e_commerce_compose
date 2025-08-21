package com.route.e_commerce.features.auth.login.data.sources.local

import com.route.e_commerce.core.data.entities.UserEntity

interface LoginLocalDataSource {
    suspend fun storeUserData(userEntity: UserEntity?)
}