package com.route.e_commerce.core.di

import com.route.e_commerce.features.auth.forget_password.domain.use_case.SendResetPasswordEmailUseCase
import com.route.e_commerce.features.auth.forget_password.domain.use_case.VerifyOTPUseCase
import com.route.e_commerce.features.auth.login.domain.use_case.LoginUseCase
import com.route.e_commerce.features.auth.reset_password.domain.use_case.ResetPasswordUseCase
import com.route.e_commerce.features.auth.signup.domain.use_case.SignupUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchCategoriesUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchElectronicsUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchNewArrivalsUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchShoesUseCase
import com.route.e_commerce.features.splash.domain.use_case.FetchUserEntityUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { FetchUserEntityUseCase(get()) }
    factory { SignupUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { SendResetPasswordEmailUseCase(get()) }
    factory { VerifyOTPUseCase(get()) }
    factory { ResetPasswordUseCase(get()) }
    factory { FetchCategoriesUseCase(get()) }
    factory { FetchNewArrivalsUseCase(get()) }
    factory { FetchShoesUseCase(get()) }
    factory { FetchElectronicsUseCase(get()) }
}