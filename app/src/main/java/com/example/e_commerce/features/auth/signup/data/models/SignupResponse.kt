package com.example.e_commerce.features.auth.signup.data.models

import com.example.e_commerce.core.data_entity.UserEntity
import com.example.e_commerce.core.data_models.User
import com.google.gson.annotations.SerializedName

class SignupResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("token")
    val token: String? = null
) : UserEntity(
    name = user?.name ?: "",
    email = user?.email ?: "",
    role = user?.role ?: "",
    currentToken = token ?: ""
)