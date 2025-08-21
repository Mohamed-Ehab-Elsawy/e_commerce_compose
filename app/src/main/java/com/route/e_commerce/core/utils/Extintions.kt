package com.route.e_commerce.core.utils

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import com.route.e_commerce.core.data.models.ErrorResponse
import retrofit2.Response

fun <T> handleResponse(response: Response<T>): Result<T> {
    return if (response.isSuccessful) {
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
}

fun showToast(context: Context, msg: String) {
    Toast.makeText(
        context, msg, Toast.LENGTH_SHORT
    ).show()
}