package com.route.e_commerce.features.auth.reset_password.data.remote_source

import com.route.e_commerce.core.utils.handleResponse
import com.route.e_commerce.features.auth.reset_password.data.api.ResetPasswordAPI
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse

class ResetPasswordRemoteDataSourceImpl(
    private val resetPasswordAPI: ResetPasswordAPI
) : ResetPasswordRemoteDataSource {
    override suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): Result<ResetPasswordResponse> {
        return try {
            val response = resetPasswordAPI.resetPassword(resetPasswordRequest)
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}