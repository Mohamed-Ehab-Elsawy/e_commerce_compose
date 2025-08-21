package com.route.e_commerce.features.auth.reset_password.presentation.events

sealed class ResetPasswordEvents {
    object NavigateToLogin : ResetPasswordEvents()
    data class ShowError(val message: String) : ResetPasswordEvents()
}