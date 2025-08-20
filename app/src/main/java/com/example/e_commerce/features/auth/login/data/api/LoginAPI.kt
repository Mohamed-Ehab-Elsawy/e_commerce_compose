package com.example.e_commerce.features.auth.login.data.api

import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("auth/signin")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}