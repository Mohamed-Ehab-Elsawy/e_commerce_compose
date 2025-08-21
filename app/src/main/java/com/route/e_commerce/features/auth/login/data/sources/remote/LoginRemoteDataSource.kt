package com.route.e_commerce.features.auth.login.data.sources.remote

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.login.data.models.LoginRequest

interface LoginRemoteDataSource {
    suspend fun login(loginRequest: LoginRequest): Result<AuthResponse>
}