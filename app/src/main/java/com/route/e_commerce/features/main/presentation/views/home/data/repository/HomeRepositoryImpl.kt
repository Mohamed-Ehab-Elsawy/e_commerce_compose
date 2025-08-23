package com.route.e_commerce.features.main.presentation.views.home.data.repository

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.data.network_manager.NetworkMonitor
import com.route.e_commerce.features.main.presentation.views.home.data.sources.local.HomeLocalDataSource
import com.route.e_commerce.features.main.presentation.views.home.data.sources.remote.HomeRemoteDataSource
import com.route.e_commerce.features.main.presentation.views.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val networkMonitor: NetworkMonitor,
    private val localDataSource: HomeLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun fetchCategories(): Result<List<CategoryEntity>?> =
        if (networkMonitor.isConnected.value) {
            val result = remoteDataSource.fetchCategories()
            result.fold(
                onSuccess = { data ->
                    val list = data.data?.map { it!!.toCategoryEntity() } ?: emptyList()
                    storeCategoriesLocally(list)
                    Result.success(list)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
        } else
            Result.success(fetchCategoriesFromLocalSource())


    override suspend fun fetchNewArrivalsProducts(): Result<List<ProductEntity>?> =
        if (networkMonitor.isConnected.value) {
            val result = remoteDataSource.fetchNewArrivalsProducts()
            result.fold(
                onSuccess = { data ->
                    val list = data.data?.map { it!!.toProductEntity() } ?: emptyList()
                    storeNewArrivalsProductsLocally(list)
                    Result.success(list)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
        } else
            Result.success(fetchNewArrivalsProductsFromLocalSource())


    override suspend fun fetchShoesProducts(): Result<List<ProductEntity>?> =
        if (networkMonitor.isConnected.value) {
            val result = remoteDataSource.fetchShoesProducts()
            result.fold(
                onSuccess = { data ->
                    val list = data.data?.map { it!!.toProductEntity() } ?: emptyList()
                    storeShoesProductsLocally(list)
                    Result.success(list)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
        } else
            Result.success(fetchShoesProductsFromLocalSource())

    override suspend fun fetchElectronicsProducts(): Result<List<ProductEntity>?> =
        if (networkMonitor.isConnected.value) {
            val result = remoteDataSource.fetchElectronicsProducts()
            result.fold(
                onSuccess = { data ->
                    val list = data.data?.map { it!!.toProductEntity() } ?: emptyList()
                    storeElectronicsProductsLocally(list)
                    Result.success(list)
                },
                onFailure = {
                    Result.failure(it)
                }
            )
        } else
            Result.success(fetchElectronicsProductsFromLocalSource())

    private suspend fun fetchCategoriesFromLocalSource(): List<CategoryEntity>? =
        localDataSource.fetchCategories()

    private suspend fun storeCategoriesLocally(list: List<CategoryEntity>?) {
        if (list != null && list.isNotEmpty())
            localDataSource.putCategories(list)
    }

    private suspend fun fetchNewArrivalsProductsFromLocalSource(): List<ProductEntity>? =
        localDataSource.fetchNewArrivalsProducts()

    private suspend fun storeNewArrivalsProductsLocally(list: List<ProductEntity>?) {
        if (list != null && list.isNotEmpty())
            localDataSource.putNewArrivalsProducts(list)
    }

    private suspend fun fetchShoesProductsFromLocalSource(): List<ProductEntity>? =
        localDataSource.fetchShoesProducts()

    private suspend fun storeShoesProductsLocally(list: List<ProductEntity>?) {
        if (list != null && list.isNotEmpty())
            localDataSource.putShoesProducts(list)
    }

    private suspend fun fetchElectronicsProductsFromLocalSource(): List<ProductEntity>? =
        localDataSource.fetchElectronicsProducts()

    private suspend fun storeElectronicsProductsLocally(list: List<ProductEntity>?) {
        if (list != null && list.isNotEmpty())
            localDataSource.putElectronicsProducts(list)
    }


}