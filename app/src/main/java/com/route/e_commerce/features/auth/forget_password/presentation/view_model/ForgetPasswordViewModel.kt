package com.route.e_commerce.features.auth.forget_password.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest
import com.route.e_commerce.features.auth.forget_password.domain.use_case.SendResetPasswordEmailUseCase
import com.route.e_commerce.features.auth.forget_password.domain.use_case.VerifyOTPUseCase
import com.route.e_commerce.features.auth.forget_password.presentation.events.ForgetPasswordEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForgetPasswordViewModel(
    private val sentOTPUseCase: SendResetPasswordEmailUseCase,
    private val verifyOTPUseCase: VerifyOTPUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<Unit>>(UiState.Idle)
    val uiState: StateFlow<UiState<Unit>> = _uiState

    private val _events = MutableSharedFlow<ForgetPasswordEvents>()
    val events: SharedFlow<ForgetPasswordEvents> = _events

    fun forgetPassword(sendResetPasswordEmailRequest: SendResetPasswordEmailRequest) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            sentOTPUseCase(sendResetPasswordEmailRequest).onSuccess { data ->
                if (data.statusMsg == "success") {
                    _uiState.value = UiState.Success(Unit)
                    _events.emit(ForgetPasswordEvents.OpenOtpModalSheet(data.statusMsg))
                } else
                    _events.emit(
                        ForgetPasswordEvents.ShowError(
                            data.message
                                ?: "There is no user registered with this email address ${sendResetPasswordEmailRequest.email}"
                        )
                    )
            }.onFailure { error ->
                _uiState.value = UiState.Error(error)
                _events.emit(
                    ForgetPasswordEvents.ShowError(
                        error.localizedMessage ?: "Unknown error"
                    )
                )
            }
        }
    }

    fun verifyOTP(verifyOtpRequest: VerifyOtpRequest) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            verifyOTPUseCase.invoke(verifyOtpRequest).onSuccess { data ->
                _uiState.value = UiState.Success(Unit)
                if (data.status == "Success")
                    _events.emit(ForgetPasswordEvents.NavigateToResetPassword(data.status))
                else
                    _events.emit(
                        ForgetPasswordEvents.ShowError(
                            data.message
                                ?: "Wrong OTP"
                        )
                    )
            }.onFailure { error ->
                _uiState.value = UiState.Error(error)
                _events.emit(
                    ForgetPasswordEvents.ShowError(
                        error.localizedMessage ?: "Unknown error"
                    )
                )
            }
        }
    }

}