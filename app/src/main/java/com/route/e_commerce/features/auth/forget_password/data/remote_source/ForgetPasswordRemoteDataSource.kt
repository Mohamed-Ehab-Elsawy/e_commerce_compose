package com.route.e_commerce.features.auth.forget_password.data.remote_source

import com.route.e_commerce.features.auth.forget_password.data.models.ForgetPasswordResponse
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOTPResponse
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest

interface ForgetPasswordRemoteDataSource {
    suspend fun forgetPassword(
        sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ): Result<ForgetPasswordResponse>

    suspend fun verifyOTP(
        verifyOtpRequest: VerifyOtpRequest
    ): Result<VerifyOTPResponse>
}