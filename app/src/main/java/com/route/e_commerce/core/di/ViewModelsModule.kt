package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.forget_password.presentation.view_model.ForgetPasswordViewModel
import com.route.e_commerce.features.auth.login.presentation.view_model.LoginViewModel
import com.route.e_commerce.features.auth.reset_password.presentation.view_model.ResetPasswordViewModel
import com.route.e_commerce.features.auth.signup.presentation.viewmodel.SignupViewModel
import com.route.e_commerce.features.main.presentation.views.home.presentation.view_model.HomeViewModel
import com.route.e_commerce.features.splash.presentation.view_model.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel {
        ForgetPasswordViewModel(get(), get())
    }
    viewModel {
        ResetPasswordViewModel(get())
    }
    viewModel {
        HomeViewModel(
            get(),
            get(),
            get(),
            get()
        )
    }
}