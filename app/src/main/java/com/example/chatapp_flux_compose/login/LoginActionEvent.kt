package com.example.chatapp_flux_compose.login

sealed class LoginActionEvent {
    data class UploadUserIconSucceed(val iconUrl: String) : LoginActionEvent()
    data class UploadUserIconFailed(val errorMessage: String?) : LoginActionEvent()

    object RegisterBasicUserInfoSucceed : LoginActionEvent()
    data class RegisterBasicUserInfoFailed(val errorMessage: String?) : LoginActionEvent()

    object LoadingStatusState : LoginActionEvent()
}