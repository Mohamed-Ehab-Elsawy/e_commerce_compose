package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.forget_password.data.api.ForgetPasswordAPI
import com.route.e_commerce.features.auth.login.data.api.LoginAPI
import com.route.e_commerce.features.auth.reset_password.data.api.ResetPasswordAPI
import com.route.e_commerce.features.auth.signup.data.api.SignupAPI
import org.koin.dsl.module
import retrofit2.Retrofit

val apisModule = module {
    single<SignupAPI> { get<Retrofit>().create(SignupAPI::class.java) }
    single<LoginAPI> { get<Retrofit>().create(LoginAPI::class.java) }
    single<ForgetPasswordAPI> { get<Retrofit>().create(ForgetPasswordAPI::class.java) }
    single<ResetPasswordAPI> { get<Retrofit>().create(ResetPasswordAPI::class.java) }

}