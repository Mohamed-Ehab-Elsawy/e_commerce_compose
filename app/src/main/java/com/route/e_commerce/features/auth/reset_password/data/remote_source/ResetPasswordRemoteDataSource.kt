package com.route.e_commerce.features.auth.reset_password.data.remote_source

import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse

interface ResetPasswordRemoteDataSource {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): Result<ResetPasswordResponse>
}