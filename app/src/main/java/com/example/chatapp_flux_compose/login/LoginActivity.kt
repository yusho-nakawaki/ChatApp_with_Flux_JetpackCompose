package com.example.chatapp_flux_compose.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.chatapp_flux_compose.ui.theme.ChatApp_Flux_ComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApp_Flux_ComposeTheme {
                Surface {
                    LoginActivityScreen()
                }
            }
        }
    }
}

@Composable
private fun LoginActivityScreen() {

}