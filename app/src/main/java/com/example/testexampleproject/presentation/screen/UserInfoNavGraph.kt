package com.example.testexampleproject.presentation.screen

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.testexampleproject.app.di.AppModule
import com.example.testexampleproject.presentation.viewmodel.UserInfoViewModel


fun NavGraphBuilder.UserInfoGraph(
    navHostController: NavHostController,
    appModule: AppModule
) {
    navigation(
        route = "UserInfo",
        startDestination = "ScreenA"
    ) {
        composable("ScreenA") {
            val userInfoViewModel = ViewModelProvider(
                LocalViewModelStoreOwner.current!!,
                appModule.provideUserInfoViewModelFactory()
            )
                .get(UserInfoViewModel::class.java)
            ScreenA(userInfoViewModel, navHostController)
        }
        composable("UserInfoScreen") {
            val userInfoViewModel = ViewModelProvider(
                LocalViewModelStoreOwner.current!!,
                appModule.provideUserInfoViewModelFactory()
            )
                .get(UserInfoViewModel::class.java)
            UserInfoScreen(userInfoViewModel, navHostController)
        }
    }
}