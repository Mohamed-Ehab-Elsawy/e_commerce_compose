package com.route.e_commerce.features.main.presentation.views.home.domain.use_case

import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.features.main.presentation.views.home.domain.repository.HomeRepository

class FetchElectronicsUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<ProductEntity>?> =
        homeRepository.fetchElectronicsProducts()
}