package com.route.e_commerce.features.auth.forget_password.data.remote_source

import com.route.e_commerce.core.utils.handleResponse
import com.route.e_commerce.features.auth.forget_password.data.api.ForgetPasswordAPI
import com.route.e_commerce.features.auth.forget_password.data.models.ForgetPasswordResponse
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOTPResponse
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest

class ForgetPasswordRemoteDataSourceImpl(
    private val forgetPasswordAPI: ForgetPasswordAPI
) : ForgetPasswordRemoteDataSource {
    override suspend fun forgetPassword(
        sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ): Result<ForgetPasswordResponse> {
        return try {
            val response =
                forgetPasswordAPI.forgetPassword(sendResetPasswordEmailRequest)
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun verifyOTP(
        verifyOtpRequest: VerifyOtpRequest
    ): Result<VerifyOTPResponse> {
        return try {
            val response = forgetPasswordAPI.verifyOTP(verifyOtpRequest)
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }


}