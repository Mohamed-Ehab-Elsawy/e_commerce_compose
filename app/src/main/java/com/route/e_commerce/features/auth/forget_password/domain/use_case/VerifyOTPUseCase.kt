package com.route.e_commerce.features.auth.forget_password.domain.use_case

import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest
import com.route.e_commerce.features.auth.forget_password.domain.repository.ForgetPasswordRepository

class VerifyOTPUseCase(
    private val forgetPasswordRepository: ForgetPasswordRepository
) {
    suspend operator fun invoke(verifyOtpRequest: VerifyOtpRequest) =
        forgetPasswordRepository.verifyOTP(verifyOtpRequest)
}