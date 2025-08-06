package com.example.testexampleproject.domain.repository

import com.example.testexampleproject.data.model.UserModel
import com.example.testexampleproject.data.network.adapter.ApiResult

interface AuthRepository {
    suspend fun getUserInformation(): ApiResult<UserModel>
}