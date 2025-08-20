package com.example.e_commerce.features.auth.signup.data.api

import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupAPI {
    @POST("auth/signup")
    suspend fun signup(@Body signupRequest: SignupRequest): Response<SignupResponse>
}