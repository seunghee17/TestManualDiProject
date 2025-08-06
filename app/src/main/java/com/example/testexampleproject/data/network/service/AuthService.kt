package com.example.testexampleproject.data.network.service

import com.example.testexampleproject.data.model.UserModel
import com.example.testexampleproject.data.network.adapter.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthService {

    @GET("/api/user")
    suspend fun getUserInformation(): ApiResult<UserModel>
}