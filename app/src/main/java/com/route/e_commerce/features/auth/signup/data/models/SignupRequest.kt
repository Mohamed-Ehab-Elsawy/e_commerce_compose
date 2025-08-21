package com.route.e_commerce.features.auth.signup.data.models

data class SignupRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String,
    val rePassword: String
)