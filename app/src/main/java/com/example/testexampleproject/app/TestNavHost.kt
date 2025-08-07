package com.example.testexampleproject.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.testexampleproject.app.di.AppModule
import com.example.testexampleproject.presentation.screen.UserInfoGraph

@Composable
fun TestNavigation(appModule: AppModule) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "UserInfo" //네비게이션 그래프에 직접 자식을 작성해야한다
    ) {
        UserInfoGraph(navHostController = navController,appModule = appModule)
    }
}