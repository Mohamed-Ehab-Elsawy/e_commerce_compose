package com.route.e_commerce.features.auth.forget_password.data.models

import com.google.gson.annotations.SerializedName

data class ForgetPasswordResponse(

    @field:SerializedName("statusMsg")
    val statusMsg: String? = null,

    @field:SerializedName("message")
    val message: String? = null
)