package com.example.e_commerce.features.auth.login.data.sources

import com.example.e_commerce.core.data_models.ErrorResponse
import com.example.e_commerce.features.auth.login.data.api.LoginAPI
import com.example.e_commerce.features.auth.login.data.models.LoginRequest
import com.example.e_commerce.features.auth.login.data.models.LoginResponse
import com.google.gson.Gson

class LoginRemoteDataSourceImpl(private val loginAPI: LoginAPI) : LoginRemoteDataSource {
    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            val response = loginAPI.login(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(Exception("Empty response body"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
                Result.failure(Exception(errorResponse.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}