package com.example.e_commerce.features.auth.signup.presentation.events

sealed class SignupEvent {
    data class ShowError(val message: String) : SignupEvent()
    object NavigateToHome : SignupEvent()
}