package com.example.testexampleproject.domain.usecase

import com.example.testexampleproject.data.model.UserModel
import com.example.testexampleproject.data.network.adapter.ApiResult
import com.example.testexampleproject.domain.repository.AuthRepository

class GetUserInformationUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): ApiResult<UserModel> {
        return authRepository.getUserInformation()
    }
}