package com.route.e_commerce.features.auth.login.domain.use_case

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.login.data.models.LoginRequest
import com.route.e_commerce.features.auth.login.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(loginRequest: LoginRequest): Result<AuthResponse> =
        loginRepository.login(loginRequest)
}