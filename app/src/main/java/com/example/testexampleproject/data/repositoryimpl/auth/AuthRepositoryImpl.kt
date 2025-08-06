package com.example.testexampleproject.data.repositoryimpl.auth

import com.example.testexampleproject.data.model.UserModel
import com.example.testexampleproject.data.network.adapter.ApiResult
import com.example.testexampleproject.data.network.service.AuthService
import com.example.testexampleproject.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authService: AuthService): AuthRepository {
    override suspend fun getUserInformation(): ApiResult<UserModel> {
        return authService.getUserInformation()
    }

}