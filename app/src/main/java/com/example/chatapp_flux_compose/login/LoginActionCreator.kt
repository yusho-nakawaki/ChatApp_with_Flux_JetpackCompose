package com.example.chatapp_flux_compose.login

import com.example.chatapp_flux_compose.data.architecture.Dispatcher
import com.example.chatapp_flux_compose.data.preference.UserPreference

class LoginActionCreator(
    private val dispatcher: Dispatcher,
    private val userPreference: UserPreference,
) {

    fun hoge() {
        print("hello")
    }

}