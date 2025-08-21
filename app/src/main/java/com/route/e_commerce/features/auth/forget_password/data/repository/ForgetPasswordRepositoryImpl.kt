package com.route.e_commerce.features.auth.forget_password.data.repository

import com.route.e_commerce.features.auth.forget_password.data.models.ForgetPasswordResponse
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOTPResponse
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest
import com.route.e_commerce.features.auth.forget_password.data.remote_source.ForgetPasswordRemoteDataSource
import com.route.e_commerce.features.auth.forget_password.domain.repository.ForgetPasswordRepository

class ForgetPasswordRepositoryImpl(
    private val forgetPasswordRemoteDataSource: ForgetPasswordRemoteDataSource
) : ForgetPasswordRepository {
    override suspend fun sendPasswordResetEmail(
        sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ): Result<ForgetPasswordResponse> =
        forgetPasswordRemoteDataSource.forgetPassword(sendResetPasswordEmailRequest)

    override suspend fun verifyOTP(
        verifyOtpRequest: VerifyOtpRequest
    ): Result<VerifyOTPResponse> =
        forgetPasswordRemoteDataSource.verifyOTP(verifyOtpRequest)
}