package com.example.testexampleproject.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testexampleproject.presentation.viewmodel.UserInfoViewModel

class AppModule () {
    private val networkModule = NetworkModule()

    private val repositoryModule = RepositoryModule(authService = networkModule.authService)

    private val useCaseModule = UseCaseModule(authRepository = repositoryModule.provideAuthRepository)

    fun provideUserInfoViewModelFactory(): ViewModelProvider.Factory {
        return object: ViewModelProvider.Factory {
            override fun <T: ViewModel> create(modelClass: Class<T>): T {
                return UserInfoViewModel(getUserInformationUseCase = useCaseModule.provideGetUserInfoUseCase) as T
            }
        }
    }
}