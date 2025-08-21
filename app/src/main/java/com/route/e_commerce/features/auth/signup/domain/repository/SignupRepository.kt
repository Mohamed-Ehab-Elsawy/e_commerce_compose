package com.route.e_commerce.features.auth.signup.domain.repository

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest

interface SignupRepository {
    suspend fun signup(signupRequest: SignupRequest): Result<AuthResponse>
}