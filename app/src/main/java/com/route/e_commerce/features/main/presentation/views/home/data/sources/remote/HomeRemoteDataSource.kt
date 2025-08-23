package com.route.e_commerce.features.main.presentation.views.home.data.sources.remote

import com.route.e_commerce.core.data.models.ProductsResponse
import com.route.e_commerce.features.main.presentation.views.home.data.models.CategoriesResponse

interface HomeRemoteDataSource {
    suspend fun fetchCategories(): Result<CategoriesResponse>
    suspend fun fetchNewArrivalsProducts(): Result<ProductsResponse>
    suspend fun fetchShoesProducts(): Result<ProductsResponse>
    suspend fun fetchElectronicsProducts(): Result<ProductsResponse>
}