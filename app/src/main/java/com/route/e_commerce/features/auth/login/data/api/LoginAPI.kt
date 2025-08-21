package com.route.e_commerce.features.auth.login.data.api

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.login.data.models.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("auth/signin")
    suspend fun login(@Body loginRequest: LoginRequest): Response<AuthResponse>
}