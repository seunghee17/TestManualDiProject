package com.example.testexampleproject.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testexampleproject.presentation.contract.UserInfoContract
import com.example.testexampleproject.presentation.viewmodel.UserInfoViewModel
import com.example.testexampleproject.ui.theme.TestExampleProjectTheme
import kotlinx.coroutines.flow.collectLatest
import java.lang.reflect.Modifier

//@Composable
//fun UserInfoScreen(
//    viewModel: UserInfoViewModel
//) {
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    val effectFlow = viewModel.effect
//    val context = LocalContext.current
//
//    LaunchedEffect(true) { effect ->
//        effectFlow.collectLatest {
//            when(effect) {
//                is UserInfoContract.Effect.Toastmessage -> {
//                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//
//    TestExampleProjectTheme {
//        Column (
//            modifier = Modifier.fillMaxSize()
//        ) {
//            if(uiState.isLoading) {
//                loadingScreen(modifier = modifier)
//            } else {
//
//            }
//        }
//    }
//
//}
//
//@Composable
//fun loadingScreen(val modifier) {
//    Column(
//        modifier = modifier
//    ) {
//
//    }
//}