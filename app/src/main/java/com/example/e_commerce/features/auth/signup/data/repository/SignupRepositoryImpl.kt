package com.example.e_commerce.features.auth.signup.data.repository

import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse
import com.example.e_commerce.features.auth.signup.data.sources.SignupRemoteDataSource
import com.example.e_commerce.features.auth.signup.domain.repository.SignupRepository

class SignupRepositoryImpl(
    private val remoteDataSource: SignupRemoteDataSource
) : SignupRepository {
    override suspend fun signup(signupRequest: SignupRequest): Result<SignupResponse> =
        remoteDataSource.signup(signupRequest)
}