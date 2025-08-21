package com.route.e_commerce.features.splash.domain.use_case

import com.route.e_commerce.core.data.entities.UserEntity
import com.route.e_commerce.features.splash.domain.repository.SplashRepository

class FetchUserEntityUseCase(
    private val splashRepository: SplashRepository
) {
    suspend operator fun invoke(): UserEntity? = splashRepository.fetchUserEntity()
}