package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.forget_password.data.repository.ForgetPasswordRepositoryImpl
import com.route.e_commerce.features.auth.forget_password.domain.repository.ForgetPasswordRepository
import com.route.e_commerce.features.auth.login.data.repository.LoginRepositoryImpl
import com.route.e_commerce.features.auth.login.domain.repository.LoginRepository
import com.route.e_commerce.features.auth.reset_password.data.repository.ResetPasswordRepositoryImpl
import com.route.e_commerce.features.auth.reset_password.domain.repository.ResetPasswordRepository
import com.route.e_commerce.features.auth.signup.data.repository.SignupRepositoryImpl
import com.route.e_commerce.features.auth.signup.domain.repository.SignupRepository
import com.route.e_commerce.features.main.presentation.views.home.data.repository.HomeRepositoryImpl
import com.route.e_commerce.features.main.presentation.views.home.domain.repository.HomeRepository
import com.route.e_commerce.features.splash.data.repository.SplashRepositoryImpl
import com.route.e_commerce.features.splash.domain.repository.SplashRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single<SplashRepository> {
        SplashRepositoryImpl(get())
    }

    single<SignupRepository> {
        SignupRepositoryImpl(get(), get())
    }
    single<LoginRepository> {
        LoginRepositoryImpl(get(), get())
    }
    single<ForgetPasswordRepository> {
        ForgetPasswordRepositoryImpl(get())
    }
    single<ResetPasswordRepository> {
        ResetPasswordRepositoryImpl(get())
    }
    single<HomeRepository> {
        HomeRepositoryImpl(
            get(), get(), get()
        )
    }

}