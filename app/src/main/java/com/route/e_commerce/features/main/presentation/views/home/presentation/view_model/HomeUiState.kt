package com.route.e_commerce.features.main.presentation.views.home.presentation.view_model

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.ui.UiState

data class HomeUiState(
    val categories: UiState<List<CategoryEntity>?> = UiState.Idle,
    val newArrivals: UiState<List<ProductEntity>?> = UiState.Idle,
    val shoes: UiState<List<ProductEntity>?> = UiState.Idle,
    val electronics: UiState<List<ProductEntity>?> = UiState.Idle
)