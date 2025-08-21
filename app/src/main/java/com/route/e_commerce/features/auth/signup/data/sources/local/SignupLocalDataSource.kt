package com.route.e_commerce.features.auth.signup.data.sources.local

import com.route.e_commerce.core.data.entities.UserEntity

interface SignupLocalDataSource {
    suspend fun storeUserData(userEntity: UserEntity?)
}