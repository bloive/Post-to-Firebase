package com.example.something.network

import com.example.something.App
import com.example.something.models.SignUpResponse
import com.example.something.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface RetrofitRepository {
    @POST("/v1/accounts:signUp")
    suspend fun signUp(
        @Body user: User,
        @Query("key") key: String = App.key
    ): Response<SignUpResponse>
}