package com.route.e_commerce.features.main.presentation.views.home.data.sources.remote

import com.route.e_commerce.core.data.models.ProductsResponse
import com.route.e_commerce.core.utils.handleResponse
import com.route.e_commerce.features.main.presentation.views.home.data.api.HomeAPI
import com.route.e_commerce.features.main.presentation.views.home.data.models.CategoriesResponse

class HomeRemoteDataSourceImpl(
    private val homeAPI: HomeAPI
) : HomeRemoteDataSource {
    override suspend fun fetchCategories(): Result<CategoriesResponse> = try {
        val response = homeAPI.fetchCategories()
        handleResponse(response)
    } catch (t: Throwable) {
        Result.failure(t)
    }

    override suspend fun fetchNewArrivalsProducts(): Result<ProductsResponse> =
        try {
            val response = homeAPI.fetchNewArrivalsProducts()
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }

    override suspend fun fetchShoesProducts(): Result<ProductsResponse> =
        try {
            val response = homeAPI.fetchShoesProducts()
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }

    override suspend fun fetchElectronicsProducts(): Result<ProductsResponse> =
        try {
            val response = homeAPI.fetchElectronicsProducts()
            handleResponse(response)
        } catch (t: Throwable) {
            Result.failure(t)
        }

}