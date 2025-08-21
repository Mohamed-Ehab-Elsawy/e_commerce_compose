package com.route.e_commerce.features.auth.forget_password.data.api

import com.route.e_commerce.features.auth.forget_password.data.models.ForgetPasswordResponse
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOTPResponse
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ForgetPasswordAPI {
    @POST("auth/forgotPasswords")
    suspend fun forgetPassword(
        @Body sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ): Response<ForgetPasswordResponse>

    @POST("auth/verifyResetCode")
    suspend fun verifyOTP(
        @Body verifyOtpRequest: VerifyOtpRequest
    ): Response<VerifyOTPResponse>
}