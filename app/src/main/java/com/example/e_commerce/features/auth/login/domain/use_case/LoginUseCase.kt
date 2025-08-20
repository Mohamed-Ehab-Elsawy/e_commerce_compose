package com.example.e_commerce.features.auth.login.domain.use_case

import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse
import com.example.e_commerce.features.auth.login.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(loginRequest: LoginRequest): Result<LoginResponse> =
        loginRepository.login(loginRequest)
}