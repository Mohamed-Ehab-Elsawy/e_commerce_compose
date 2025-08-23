package com.route.e_commerce.features.auth.signup.data.sources.remote

import com.route.e_commerce.core.data.models.AuthResponse
import com.route.e_commerce.core.data.store.DataStoreManager
import com.route.e_commerce.core.utils.handleResponse
import com.route.e_commerce.features.auth.signup.data.api.SignupAPI
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest
import retrofit2.Response

class SignupRemoteDataSourceImpl(
    private val signupAPI: SignupAPI,
    private val dataStoreManager: DataStoreManager
) : SignupRemoteDataSource {
    override suspend fun signup(signupRequest: SignupRequest): Result<AuthResponse> {
        return try {
            val response = signupAPI.signup(signupRequest)
            storeUserData(response)
            handleResponse(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun storeUserData(response: Response<AuthResponse>) {
        val userEntity = response.body()?.toUserEntity()
        if (userEntity != null)
            dataStoreManager.putUser(userEntity)
    }
}