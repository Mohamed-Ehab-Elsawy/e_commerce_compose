package com.example.e_commerce.features.auth.login.data.repository

import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse
import com.example.e_commerce.features.auth.login.data.sources.LoginRemoteDataSource
import com.example.e_commerce.features.auth.login.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val remoteDataSource: LoginRemoteDataSource
) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> =
        remoteDataSource.login(loginRequest)
}