package com.route.e_commerce.features.auth.signup.data.api

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupAPI {
    @POST("auth/signup")
    suspend fun signup(@Body signupRequest: SignupRequest): Response<AuthResponse>
}