package com.route.e_commerce.features.auth.signup.data.sources.remote

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest

interface SignupRemoteDataSource {
    suspend fun signup(signupRequest: SignupRequest): Result<AuthResponse>
}