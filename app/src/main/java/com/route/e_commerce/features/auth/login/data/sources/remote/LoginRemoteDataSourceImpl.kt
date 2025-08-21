package com.route.e_commerce.features.auth.login.data.sources.remote

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.core.utils.handleResponse
import com.route.e_commerce.features.auth.login.data.api.LoginAPI
import com.route.e_commerce.features.auth.login.data.models.LoginRequest

class LoginRemoteDataSourceImpl(
    private val loginAPI: LoginAPI
) : LoginRemoteDataSource {
    override suspend fun login(loginRequest: LoginRequest): Result<AuthResponse> {
        return try {
            val response = loginAPI.login(loginRequest)
            handleResponse(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}