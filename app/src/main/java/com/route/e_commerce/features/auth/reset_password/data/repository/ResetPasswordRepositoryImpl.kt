package com.route.e_commerce.features.auth.reset_password.data.repository

import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse
import com.route.e_commerce.features.auth.reset_password.data.remote_source.ResetPasswordRemoteDataSource
import com.route.e_commerce.features.auth.reset_password.domain.repository.ResetPasswordRepository

class ResetPasswordRepositoryImpl(
    private val resetPasswordRemoteDataSource: ResetPasswordRemoteDataSource
) : ResetPasswordRepository {
    override suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): Result<ResetPasswordResponse> =
        resetPasswordRemoteDataSource.resetPassword(resetPasswordRequest)

}