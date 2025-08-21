package com.route.e_commerce.features.auth.forget_password.presentation.events

sealed class ForgetPasswordEvents {
    data class OpenOtpModalSheet(val message: String) : ForgetPasswordEvents()
    data class NavigateToResetPassword(val message: String) : ForgetPasswordEvents()
    data class ShowError(val message: String) : ForgetPasswordEvents()
}