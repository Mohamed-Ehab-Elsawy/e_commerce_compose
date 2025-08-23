package com.route.e_commerce.features.main.presentation.views.home.data.sources.local

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity

interface HomeLocalDataSource {
    suspend fun putCategories(categories: List<CategoryEntity>)
    suspend fun fetchCategories(): List<CategoryEntity>?

    suspend fun putNewArrivalsProducts(products: List<ProductEntity>)
    suspend fun fetchNewArrivalsProducts(): List<ProductEntity>?
    suspend fun putShoesProducts(products: List<ProductEntity>)
    suspend fun fetchShoesProducts(): List<ProductEntity>?
    suspend fun putElectronicsProducts(products: List<ProductEntity>)
    suspend fun fetchElectronicsProducts(): List<ProductEntity>?

}