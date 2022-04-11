package com.example.chatapp_flux_compose.login

import android.graphics.Bitmap

sealed class LoginActionEvent {
    data class UploadUserIconSucceed(val iconUrl: String, val iconBitmap: Bitmap) : LoginActionEvent()
    data class UploadUserIconFailed(val errorMessage: String) : LoginActionEvent()
}