package com.example.testexampleproject.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.testexampleproject.cmm.BaseViewModel
import com.example.testexampleproject.data.network.adapter.ApiResult
import com.example.testexampleproject.domain.usecase.GetUserInformationUseCase
import com.example.testexampleproject.presentation.contract.UserInfoContract
import kotlinx.coroutines.launch

class UserInfoViewModel(
    private val getUserInformationUseCase: GetUserInformationUseCase
): BaseViewModel<UserInfoContract.Event, UserInfoContract.State, UserInfoContract.Effect>(
    initialState = UserInfoContract.State()
) {

    init {
        viewModelScope.launch {
            getUserList()
        }
    }

    override fun reduceState(event: UserInfoContract.Event) {
        when(event) {
            is UserInfoContract.Event.GetUserDetailEvent-> {
                viewModelScope.launch {
                    //사용자 상세 조회
                }
            }
            else ->{}
        }
    }

//여기서 viewmodel scope 해서 코루틴 시작하면 reducestate에서 비동기처리 되는지..?
    private suspend fun getUserList() {
        viewModelScope.launch {
            val result = getUserInformationUseCase.invoke()
            when(result) {
                is ApiResult.Success -> {
                    updateState(currentState.copy(userData = result.data, isLoaging = false))
                }
                is ApiResult.Failure.UnknownApiError -> {
                    postEffect(UserInfoContract.Effect.Toastmessage("서버 관리자에게 문의하세요"))
                }
                is ApiResult.Failure.NetworkError -> {
                    postEffect(UserInfoContract.Effect.Toastmessage("네트워크 연결 확인해주세요."))
                }
                is ApiResult.Failure.HttpError -> {
                    postEffect(UserInfoContract.Effect.Toastmessage("Http 오류가 발생했습니다"))
                }
            }
        }
    }

}