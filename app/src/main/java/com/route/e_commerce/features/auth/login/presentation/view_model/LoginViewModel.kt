package com.route.e_commerce.features.auth.login.presentation.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.auth.login.data.models.LoginRequest
import com.route.e_commerce.features.auth.login.domain.use_case.LoginUseCase
import com.route.e_commerce.features.auth.login.presentation.events.LoginEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<AuthResponse>>(UiState.Idle)
    val uiState: StateFlow<UiState<AuthResponse>> = _uiState

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
                Log.e("LoginViewModel", "Error: ${error.localizedMessage}")
            }
        }
    }
}