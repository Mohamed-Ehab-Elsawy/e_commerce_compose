package com.route.e_commerce.features.auth.reset_password.data.api

import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface ResetPasswordAPI {
    @PUT("auth/resetPassword")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest):
            Response<ResetPasswordResponse>
}