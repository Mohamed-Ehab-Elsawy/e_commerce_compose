package com.example.e_commerce.features.auth.signup.domain.repository

import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse

interface SignupRepository {
    suspend fun signup(signupRequest: SignupRequest): Result<SignupResponse>
}