package com.example.e_commerce.features.auth.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.core.ui.UiState
import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse
import com.example.e_commerce.features.auth.login.domain.use_case.LoginUseCase
import com.example.e_commerce.features.auth.login.presentation.events.LoginEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<LoginResponse>>(UiState.Idle)
    val uiState: StateFlow<UiState<LoginResponse>> = _uiState

    private val _events = MutableSharedFlow<LoginEvent>()
    val events: SharedFlow<LoginEvent> = _events

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            loginUseCase(loginRequest).onSuccess { data ->
                _uiState.value = UiState.Success(data)
                _events.emit(LoginEvent.NavigateToHome)
            }.onFailure { error ->
                _uiState.value = UiState.Error(error)
                _events.emit(
                    LoginEvent.ShowError(
                        error.localizedMessage ?: "Unknown error"
                    )
                )
            }
        }
    }
}