package com.example.e_commerce.features.auth.login.data.sources

import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse

interface LoginRemoteDataSource {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>
}