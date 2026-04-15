package com.example.compose.data.remote

import retrofit2.http.GET

interface FactCatApi {
    @GET("fact")
    suspend fun getFactCat(): FactCatResponse
}
data class FactCatResponse(
    val fact: String,
    val length: Int
)