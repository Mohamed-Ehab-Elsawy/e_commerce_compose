package com.example.e_commerce.features.auth.signup.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.core.ui.UiState
import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse
import com.example.e_commerce.features.auth.signup.domain.use_case.SignupUseCase
import com.example.e_commerce.features.auth.signup.presentation.events.SignupEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignupViewModel(
    private val signupUseCase: SignupUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<SignupResponse>>(UiState.Idle)
    val uiState: StateFlow<UiState<SignupResponse>> = _uiState

    private val _events = MutableSharedFlow<SignupEvent>()
    val events: SharedFlow<SignupEvent> = _events

    fun signup(signupRequest: SignupRequest) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            signupUseCase(signupRequest)
                .onSuccess { data ->
                    _uiState.value = UiState.Success(data)
                    _events.emit(SignupEvent.NavigateToHome)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(error)
                    _events.emit(
                        SignupEvent.ShowError(
                            error.localizedMessage ?: "Unknown error"
                        )
                    )
                }
        }
    }
}