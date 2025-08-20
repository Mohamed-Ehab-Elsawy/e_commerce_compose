package com.example.e_commerce.core.di

import com.example.e_commerce.features.auth.login.data.api.LoginAPI
import com.example.e_commerce.features.auth.signup.data.api.SignupAPI
import org.koin.dsl.module
import retrofit2.Retrofit

val apisModule = module {
    single<SignupAPI> { get<Retrofit>().create(SignupAPI::class.java) }
    single<LoginAPI> { get<Retrofit>().create(LoginAPI::class.java) }
}