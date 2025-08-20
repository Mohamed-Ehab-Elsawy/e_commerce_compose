package com.example.e_commerce.features.auth.signup.domain.use_case

import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse
import com.example.e_commerce.features.auth.signup.domain.repository.SignupRepository

class SignupUseCase(private val signupRepository: SignupRepository) {
    suspend operator fun invoke(signupRequest: SignupRequest): Result<SignupResponse> =
        signupRepository.signup(signupRequest)
}