package com.route.e_commerce.features.main.presentation.views.home.data.api

import com.route.e_commerce.core.data.models.ProductsResponse
import com.route.e_commerce.features.main.presentation.views.home.data.models.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeAPI {
    @GET("categories")
    suspend fun fetchCategories(): Response<CategoriesResponse>

    @GET("products")
    suspend fun fetchNewArrivalsProducts(
        @Query("limit") limit: Int = 6,
        @Query("brand") brand: String = "64089d9e24b25627a25315a5"
    ): Response<ProductsResponse>

    @GET("products")
    suspend fun fetchShoesProducts(
        @Query("limit") limit: Int = 6,
        @Query("brand") brand: String = "64089c3924b25627a2531593"
    ): Response<ProductsResponse>

    @GET("products")
    suspend fun fetchElectronicsProducts(
        @Query("limit") limit: Int = 6,
        @Query("category[in]") brand: String = "6439d2d167d9aa4ca970649f"
    ): Response<ProductsResponse>

}