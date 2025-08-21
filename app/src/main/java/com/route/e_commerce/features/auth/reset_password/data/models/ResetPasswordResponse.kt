package com.route.e_commerce.features.auth.reset_password.data.models

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("statusMsg")
    val statusMsg: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("token")
    val token: String
)