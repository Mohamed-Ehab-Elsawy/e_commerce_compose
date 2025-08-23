package com.route.e_commerce.features.main.presentation.views.home.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchCategoriesUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchElectronicsUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchNewArrivalsUseCase
import com.route.e_commerce.features.main.presentation.views.home.domain.use_case.FetchShoesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchCategoriesUseCase: FetchCategoriesUseCase,
    private val fetchNewArrivalsUseCase: FetchNewArrivalsUseCase,
    private val fetchShoesUseCase: FetchShoesUseCase,
    private val fetchElectronicsUseCase: FetchElectronicsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(categories = UiState.Loading) }
                fetchCategoriesUseCase.invoke()
                    .onSuccess { data -> _uiState.update { it.copy(categories = UiState.Success(data)) } }
                    .onFailure { e -> _uiState.update { it.copy(categories = UiState.Error(e)) } }
            } catch (t: Throwable) {
                _uiState.update { it.copy(categories = UiState.Error(t)) }
            }
        }
    }

    fun fetchNewArrivalsProducts() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(newArrivals = UiState.Loading) }
                fetchNewArrivalsUseCase.invoke()
                    .onSuccess { data ->
                        _uiState.update {
                            it.copy(
                                newArrivals = UiState.Success(
                                    data
                                )
                            )
                        }
                    }
                    .onFailure { e -> _uiState.update { it.copy(newArrivals = UiState.Error(e)) } }
            } catch (t: Throwable) {
                _uiState.update { it.copy(newArrivals = UiState.Error(t)) }
            }
        }
    }

    fun fetchShoesProducts() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(shoes = UiState.Loading) }
                fetchShoesUseCase.invoke()
                    .onSuccess { data -> _uiState.update { it.copy(shoes = UiState.Success(data)) } }
                    .onFailure { e -> _uiState.update { it.copy(shoes = UiState.Error(e)) } }
            } catch (t: Throwable) {
                _uiState.update { it.copy(shoes = UiState.Error(t)) }
            }
        }
    }

    fun fetchElectronicsProducts() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(electronics = UiState.Loading) }
                fetchElectronicsUseCase.invoke()
                    .onSuccess { data ->
                        _uiState.update {
                            it.copy(
                                electronics = UiState.Success(
                                    data
                                )
                            )
                        }
                    }
                    .onFailure { e -> _uiState.update { it.copy(electronics = UiState.Error(e)) } }
            } catch (t: Throwable) {
                _uiState.update { it.copy(electronics = UiState.Error(t)) }
            }
        }
    }

}