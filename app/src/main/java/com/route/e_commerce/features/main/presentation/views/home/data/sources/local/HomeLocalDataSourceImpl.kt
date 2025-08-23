package com.route.e_commerce.features.main.presentation.views.home.data.sources.local

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.data.store.DataStoreManager
import kotlinx.coroutines.flow.firstOrNull

class HomeLocalDataSourceImpl(
    private val dataStoreManager: DataStoreManager
) : HomeLocalDataSource {
    override suspend fun putCategories(categories: List<CategoryEntity>) =
        dataStoreManager.putCategories(categories)

    override suspend fun fetchCategories(): List<CategoryEntity>? =
        dataStoreManager.fetchCategories().firstOrNull()

    override suspend fun putNewArrivalsProducts(products: List<ProductEntity>) =
        dataStoreManager.putProducts(
            products, DataStoreManager.NEW_ARRIVALS_PRODUCTS
        )

    override suspend fun fetchNewArrivalsProducts(): List<ProductEntity>? =
        dataStoreManager.fetchProducts(
            DataStoreManager.NEW_ARRIVALS_PRODUCTS
        ).firstOrNull()

    override suspend fun putShoesProducts(products: List<ProductEntity>) =
        dataStoreManager.putProducts(
            products, DataStoreManager.SHOES_PRODUCTS
        )

    override suspend fun fetchShoesProducts(): List<ProductEntity>? =
        dataStoreManager.fetchProducts(
            DataStoreManager.SHOES_PRODUCTS
        ).firstOrNull()

    override suspend fun putElectronicsProducts(products: List<ProductEntity>) =
        dataStoreManager.putProducts(
            products, DataStoreManager.ELECTRONICS_PRODUCTS
        )

    override suspend fun fetchElectronicsProducts(): List<ProductEntity>? =
        dataStoreManager.fetchProducts(
            DataStoreManager.ELECTRONICS_PRODUCTS
        ).firstOrNull()
}