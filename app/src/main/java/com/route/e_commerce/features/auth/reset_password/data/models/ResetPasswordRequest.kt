package com.route.e_commerce.features.auth.reset_password.data.models

data class ResetPasswordRequest(
    val email: String,
    val newPassword: String
)