package com.example.e_commerce.features.auth.login.presentation.events

sealed class LoginEvent {
    data class ShowError(val message: String) : LoginEvent()
    object NavigateToHome : LoginEvent()
}