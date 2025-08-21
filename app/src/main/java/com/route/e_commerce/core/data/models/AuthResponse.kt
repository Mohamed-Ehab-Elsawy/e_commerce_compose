package com.route.e_commerce.core.data.models

import com.route.e_commerce.core.data.entities.UserEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName("message")
    val message: String? = null,

    @SerialName("user")
    val user: User? = null,

    @SerialName("token")
    val token: String? = null
) {
    fun toUserEntity(): UserEntity = UserEntity(
        name = user?.name.orEmpty(),
        email = user?.email.orEmpty(),
        role = user?.role.orEmpty(),
        currentToken = token.orEmpty()
    )
}