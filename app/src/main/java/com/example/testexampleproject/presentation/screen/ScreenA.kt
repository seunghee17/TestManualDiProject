package com.example.testexampleproject.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.testexampleproject.presentation.contract.UserInfoContract
import com.example.testexampleproject.presentation.viewmodel.UserInfoViewModel
import com.example.testexampleproject.ui.theme.TestExampleProjectTheme
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ScreenA(
    viewModel: UserInfoViewModel,
    navHostController: NavHostController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val effectFlow = viewModel.effect
    val context = LocalContext.current

    LaunchedEffect(true) {
        effectFlow.collectLatest { effect ->
            when(effect) {
                is UserInfoContract.Effect.Toastmessage -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
                is UserInfoContract.Effect.NavigateTo -> {
                    navHostController.navigate(effect.destination, effect.navOptions)
                }
            }
        }
    }

    TestExampleProjectTheme {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "welcome to test app Good Luck!")
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                onClick = {
                    viewModel.setEffect {
                        UserInfoContract.Effect.NavigateTo(destination = "UserInfoScreen")
                    }
                    viewModel.setEvent(event = UserInfoContract.Event.GetUserDetailEvent)
                },
                content = { Text(text = "click here") }
            )
        }
    }

}
