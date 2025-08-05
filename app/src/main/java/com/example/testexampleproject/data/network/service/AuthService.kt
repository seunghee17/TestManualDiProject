package com.example.testexampleproject.data.network.service

import com.example.testexampleproject.data.network.adapter.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthService {
    @GET("")
    suspend fun getUserInformation(
        @Query("memberId") memberId:Int
    ): ApiResult<~~~>
}