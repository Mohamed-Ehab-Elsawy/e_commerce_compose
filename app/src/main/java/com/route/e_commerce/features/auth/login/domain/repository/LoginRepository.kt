package com.route.e_commerce.features.auth.login.domain.repository

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.login.data.models.LoginRequest

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Result<AuthResponse>
}