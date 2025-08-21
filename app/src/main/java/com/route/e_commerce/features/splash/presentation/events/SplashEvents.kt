package com.route.e_commerce.features.splash.presentation.events

sealed class SplashEvents() {
    object NavigateToLogin : SplashEvents()
    object NavigateToHome : SplashEvents()

}