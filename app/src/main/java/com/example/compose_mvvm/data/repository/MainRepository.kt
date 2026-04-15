package com.example.compose_mvvm.data.repository

import com.example.compose_mvvm.data.remote.FactCatApi
import com.example.compose_mvvm.data.remote.FactCatResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: FactCatApi
) {
    suspend fun getFactCatData(): Result<FactCatResponse> {
        return try {
            val response = api.getFactCat()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}