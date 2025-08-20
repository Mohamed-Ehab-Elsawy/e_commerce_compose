package com.example.e_commerce.core.di

import com.example.e_commerce.features.auth.login.data.repository.LoginRepositoryImpl
import com.example.e_commerce.features.auth.login.domain.repository.LoginRepository
import com.example.e_commerce.features.auth.signup.data.repository.SignupRepositoryImpl
import com.example.e_commerce.features.auth.signup.domain.repository.SignupRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<SignupRepository> { SignupRepositoryImpl(get()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}