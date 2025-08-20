package com.example.e_commerce.core.di

import com.example.e_commerce.features.auth.login.data.sources.LoginRemoteDataSource
import com.example.e_commerce.features.auth.login.data.sources.LoginRemoteDataSourceImpl
import com.example.e_commerce.features.auth.signup.data.sources.SignupRemoteDataSource
import com.example.e_commerce.features.auth.signup.data.sources.SignupRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourcesModule = module {
    single<SignupRemoteDataSource> { SignupRemoteDataSourceImpl(get()) }
    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(get()) }
}