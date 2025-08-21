package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.forget_password.data.remote_source.ForgetPasswordRemoteDataSource
import com.route.e_commerce.features.auth.forget_password.data.remote_source.ForgetPasswordRemoteDataSourceImpl
import com.route.e_commerce.features.auth.login.data.sources.remote.LoginRemoteDataSource
import com.route.e_commerce.features.auth.login.data.sources.remote.LoginRemoteDataSourceImpl
import com.route.e_commerce.features.auth.reset_password.data.remote_source.ResetPasswordRemoteDataSource
import com.route.e_commerce.features.auth.reset_password.data.remote_source.ResetPasswordRemoteDataSourceImpl
import com.route.e_commerce.features.auth.signup.data.sources.remote.SignupRemoteDataSource
import com.route.e_commerce.features.auth.signup.data.sources.remote.SignupRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourcesModule = module {

    single<SignupRemoteDataSource> {
        SignupRemoteDataSourceImpl(get(), get())
    }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }

    single<ForgetPasswordRemoteDataSource> {
        ForgetPasswordRemoteDataSourceImpl(get())
    }

    single<ResetPasswordRemoteDataSource> {
        ResetPasswordRemoteDataSourceImpl(get())
    }

}