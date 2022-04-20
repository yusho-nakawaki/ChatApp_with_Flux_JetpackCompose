package com.example.chatapp_flux_compose.login

import android.graphics.Bitmap

sealed class LoginActionEvent {
    data class UploadUserIconSucceed(val iconUrl: String) : LoginActionEvent()
    data class UploadUserIconFailed(val errorMessage: String?) : LoginActionEvent()

    object RegisterBasicUserInfoSucceed : LoginActionEvent()
    data class RegisterBasicUserInfoFailed(val errorMessage: String?) : LoginActionEvent()

    object LoadingStatusState : LoginActionEvent()
}