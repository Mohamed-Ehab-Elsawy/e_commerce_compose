package com.route.e_commerce.features.splash.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.splash.domain.use_case.FetchUserEntityUseCase
import com.route.e_commerce.features.splash.presentation.events.SplashEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val fetchUserEntityUseCase: FetchUserEntityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<UserEntity?>>(UiState.Idle)
    val uiState: StateFlow<UiState<UserEntity?>> = _uiState

    private val _events = MutableSharedFlow<SplashEvents>()
    val events: SharedFlow<SplashEvents> = _events

    fun fetchUserEntity() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                val userEntity = fetchUserEntityUseCase()
                if (userEntity == null) {
                    _uiState.value = UiState.Success(null)
                    _events.emit(SplashEvents.NavigateToLogin)
                } else {
                    _uiState.value = UiState.Success(userEntity)
                    _events.emit(SplashEvents.NavigateToHome)
                }
            } catch (t: Throwable) {
                _uiState.value = UiState.Error(t)

            }
        }
    }

}