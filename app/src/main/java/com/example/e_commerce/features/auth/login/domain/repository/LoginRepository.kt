package com.example.e_commerce.features.auth.login.domain.repository

import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>
}