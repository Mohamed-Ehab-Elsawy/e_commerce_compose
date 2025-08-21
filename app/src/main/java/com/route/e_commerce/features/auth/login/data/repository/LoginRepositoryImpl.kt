package com.route.e_commerce.features.auth.login.data.repository

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.login.data.models.LoginRequest
import com.route.e_commerce.features.auth.login.data.sources.local.LoginLocalDataSource
import com.route.e_commerce.features.auth.login.data.sources.remote.LoginRemoteDataSource
import com.route.e_commerce.features.auth.login.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val remoteDataSource: LoginRemoteDataSource,
    private val localDataSource: LoginLocalDataSource
) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Result<AuthResponse> {
        val result = remoteDataSource.login(loginRequest)
        localDataSource.storeUserData(
            result.fold(
                onSuccess = { it.toUserEntity() },
                onFailure = { null }
            )
        )
        return result
    }
}