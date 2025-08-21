package com.route.e_commerce.features.auth.forget_password.domain.repository

import com.route.e_commerce.features.auth.forget_password.data.models.ForgetPasswordResponse
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOTPResponse
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest

interface ForgetPasswordRepository {
    suspend fun sendPasswordResetEmail(
        sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ): Result<ForgetPasswordResponse>

    suspend fun verifyOTP(
        verifyOtpRequest: VerifyOtpRequest
    ): Result<VerifyOTPResponse>
}