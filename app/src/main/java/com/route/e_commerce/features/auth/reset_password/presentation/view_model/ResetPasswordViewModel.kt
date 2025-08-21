package com.route.e_commerce.features.auth.reset_password.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.domain.use_case.ResetPasswordUseCase
import com.route.e_commerce.features.auth.reset_password.presentation.events.ResetPasswordEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResetPasswordViewModel(
    private val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<Unit>>(UiState.Idle)
    val uiState: StateFlow<UiState<Unit>> = _uiState

    private val _events = MutableSharedFlow<ResetPasswordEvents>()
    val events: SharedFlow<ResetPasswordEvents> = _events

    fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            resetPasswordUseCase(resetPasswordRequest).onSuccess { data ->
                _uiState.value = UiState.Success(Unit)
                if (data.token.isNotEmpty()) {
                    _events.emit(ResetPasswordEvents.NavigateToLogin)
                } else {
                    _events.emit(
                        ResetPasswordEvents.ShowError(
                            data.message
                        )
                    )
                }
            }.onFailure { error ->
                _uiState.value = UiState.Error(error)
                _events.emit(
                    ResetPasswordEvents.ShowError(
                        error.localizedMessage ?: "Unknown error"
                    )
                )
            }
        }
    }
}