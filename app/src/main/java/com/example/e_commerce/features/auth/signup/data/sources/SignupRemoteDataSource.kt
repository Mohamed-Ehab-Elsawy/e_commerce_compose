package com.example.e_commerce.features.auth.signup.data.sources

import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse

interface SignupRemoteDataSource {
    suspend fun signup(signupRequest: SignupRequest): Result<SignupResponse>
}