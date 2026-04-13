package com.example.compose.data.remote

import retrofit2.http.GET

interface ProfileApi {
    @GET("v1/api/1")
    suspend fun getProfile(): ProfileResponse
}
data class ProfileResponse(
    val name: String,
    val country: String,
    val status: String
)