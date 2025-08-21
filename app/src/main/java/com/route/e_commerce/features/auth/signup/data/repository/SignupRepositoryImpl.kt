package com.route.e_commerce.features.auth.signup.data.repository

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest
import com.route.e_commerce.features.auth.signup.data.sources.local.SignupLocalDataSource
import com.route.e_commerce.features.auth.signup.data.sources.remote.SignupRemoteDataSource
import com.route.e_commerce.features.auth.signup.domain.repository.SignupRepository

class SignupRepositoryImpl(
    private val remoteDataSource: SignupRemoteDataSource,
    private val localDataSource: SignupLocalDataSource
) : SignupRepository {
    override suspend fun signup(signupRequest: SignupRequest): Result<AuthResponse> {
        val result = remoteDataSource.signup(signupRequest)
        localDataSource.storeUserData(
            result.fold(
                onSuccess = { it.toUserEntity() },
                onFailure = { null }
            )
        )
        return result
    }
}