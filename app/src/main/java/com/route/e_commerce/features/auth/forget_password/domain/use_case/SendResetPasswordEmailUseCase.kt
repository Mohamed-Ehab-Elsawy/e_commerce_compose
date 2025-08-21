package com.route.e_commerce.features.auth.forget_password.domain.use_case

import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.domain.repository.ForgetPasswordRepository

class SendResetPasswordEmailUseCase(
    private val forgetPasswordRepository: ForgetPasswordRepository
) {
    suspend operator fun invoke(
        sendResetPasswordEmailRequest: SendResetPasswordEmailRequest
    ) = forgetPasswordRepository.sendPasswordResetEmail(sendResetPasswordEmailRequest)
}