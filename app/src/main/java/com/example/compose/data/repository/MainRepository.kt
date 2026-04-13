package com.example.compose.data.repository

import com.example.compose.data.remote.ProfileApi
import com.example.compose.data.remote.ProfileResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: ProfileApi
) {
    suspend fun getProfileData(): Result<ProfileResponse> {
        return try {
            val response = api.getProfile()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}