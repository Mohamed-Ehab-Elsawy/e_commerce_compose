package com.route.e_commerce.features.main.presentation.views.home.domain.use_case

import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.features.main.presentation.views.home.domain.repository.HomeRepository

class FetchCategoriesUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<CategoryEntity>?> =
        homeRepository.fetchCategories()
}