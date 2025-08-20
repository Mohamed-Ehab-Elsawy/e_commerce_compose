package com.example.e_commerce.core.di

import com.example.e_commerce.features.auth.login.presentation.viewmodel.LoginViewModel
import com.example.e_commerce.features.auth.signup.presentation.viewmodel.SignupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SignupViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}