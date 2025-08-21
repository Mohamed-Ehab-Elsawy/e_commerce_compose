package com.route.e_commerce.features.auth.reset_password.domain.use_case

import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse
import com.route.e_commerce.features.auth.reset_password.domain.repository.ResetPasswordRepository

class ResetPasswordUseCase(
    private val resetPasswordRepository: ResetPasswordRepository
) {
    suspend operator fun invoke(
        resetPasswordRequest: ResetPasswordRequest
    ): Result<ResetPasswordResponse> =
        resetPasswordRepository.resetPassword(resetPasswordRequest)
}