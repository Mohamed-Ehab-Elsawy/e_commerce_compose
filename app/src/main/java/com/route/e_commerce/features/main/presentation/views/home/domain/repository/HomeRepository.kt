package com.route.e_commerce.features.main.presentation.views.home.domain.repository

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity

interface HomeRepository {
    suspend fun fetchCategories(): Result<List<CategoryEntity>?>
    suspend fun fetchNewArrivalsProducts(): Result<List<ProductEntity>?>
    suspend fun fetchShoesProducts(): Result<List<ProductEntity>?>
    suspend fun fetchElectronicsProducts(): Result<List<ProductEntity>?>
}