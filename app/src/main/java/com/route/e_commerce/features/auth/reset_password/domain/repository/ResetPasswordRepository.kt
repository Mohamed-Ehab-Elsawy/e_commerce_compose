package com.route.e_commerce.features.auth.reset_password.domain.repository

import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse

interface ResetPasswordRepository {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): Result<ResetPasswordResponse>
}