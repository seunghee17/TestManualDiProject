package com.example.testexampleproject.presentation.contract

import android.content.Context
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import com.example.testexampleproject.cmm.UiEffect
import com.example.testexampleproject.cmm.UiEvent
import com.example.testexampleproject.cmm.UiState
import com.example.testexampleproject.data.model.UserModelItem

class UserInfoContract {
    data class State(
        val isLoading: Boolean = true,
        val userData: List<UserModelItem> = emptyList()
    ): UiState

    sealed class Event: UiEvent {
        object GetUserDetailEvent: Event()
    }

    sealed class Effect: UiEffect {
        data class NavigateTo(
            val destination: String,
            val navOptions: NavOptions? = null,
            val builder: NavOptionsBuilder.() -> Unit = {}
        ): Effect()
        data class Toastmessage(val message: String): Effect()
    }
}