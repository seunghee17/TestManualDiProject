package com.example.testexampleproject.app.di

import com.example.testexampleproject.data.network.service.AuthService
import com.example.testexampleproject.data.repositoryimpl.auth.AuthRepositoryImpl
import com.example.testexampleproject.domain.repository.AuthRepository

class RepositoryModule(private val authService: AuthService) {
    val provideAuthRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authService = authService)
    }
}