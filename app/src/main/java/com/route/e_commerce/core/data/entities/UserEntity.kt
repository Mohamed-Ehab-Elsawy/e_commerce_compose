package com.route.e_commerce.core.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val name: String,
    val email: String,
    val currentToken: String,
    val role: String
)