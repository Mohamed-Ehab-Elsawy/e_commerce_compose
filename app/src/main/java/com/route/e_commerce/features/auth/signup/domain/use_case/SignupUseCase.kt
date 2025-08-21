package com.route.e_commerce.features.auth.signup.domain.use_case

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest
import com.route.e_commerce.features.auth.signup.domain.repository.SignupRepository

class SignupUseCase(private val signupRepository: SignupRepository) {
    suspend operator fun invoke(signupRequest: SignupRequest): Result<AuthResponse> =
        signupRepository.signup(signupRequest)
}