package com.example.e_commerce.features.auth.signup.data.sources

import com.example.e_commerce.core.data_models.ErrorResponse
import com.example.e_commerce.features.auth.signup.data.api.SignupAPI
import com.example.e_commerce.features.auth.signup.data.models.SignupRequest
import com.example.e_commerce.features.auth.signup.data.models.SignupResponse
import com.google.gson.Gson

class SignupRemoteDataSourceImpl(private val signupAPI: SignupAPI) : SignupRemoteDataSource {
    override suspend fun signup(signupRequest: SignupRequest): Result<SignupResponse> {
        return try {
            val response = signupAPI.signup(signupRequest)
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