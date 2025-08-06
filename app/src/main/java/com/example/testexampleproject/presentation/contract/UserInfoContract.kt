package com.example.testexampleproject.presentation.contract

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
        data class GetUserDetailEvent(val userName: String): Event()
    }

    sealed class Effect: UiEffect {
        data class Toastmessage(val message: String): Effect()
    }
}