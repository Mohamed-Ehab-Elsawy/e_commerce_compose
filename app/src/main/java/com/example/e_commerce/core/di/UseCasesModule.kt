package com.example.e_commerce.core.di

import com.example.e_commerce.features.auth.login.domain.use_case.LoginUseCase
import com.example.e_commerce.features.auth.signup.domain.use_case.SignupUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { SignupUseCase(get()) }
    factory { LoginUseCase(get()) }
}