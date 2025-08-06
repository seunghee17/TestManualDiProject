package com.example.testexampleproject.app.di

import com.example.testexampleproject.domain.repository.AuthRepository
import com.example.testexampleproject.domain.usecase.GetUserInformationUseCase

class UseCaseModule(authRepository: AuthRepository) {

    val provideGetUserInfoUseCase: GetUserInformationUseCase by lazy {
        GetUserInformationUseCase(authRepository = authRepository)
    }
}