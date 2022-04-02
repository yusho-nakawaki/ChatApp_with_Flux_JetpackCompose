package com.example.chatapp_flux_compose.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.chatapp_flux_compose.data.preference.UserPreference
import com.example.chatapp_flux_compose.ui.theme.ChatApp_Flux_ComposeTheme
import org.koin.android.ext.android.inject

class LoginActivity : ComponentActivity() {

    private val userPreference: UserPreference by inject()

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatApp_Flux_ComposeTheme {
                Surface {
                    LoginScreen(
                        onUserIconTap = {

                        },
                        onCreateAccount = { userData ->
                            println("before userPref")
                            userPreference.userName = userData.userName
                            println("aaaa: ${userPreference.userName}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun LoginActivityScreen() {
    LoginScreen(
        onUserIconTap = {

        },
        onCreateAccount = { userData ->

        }
    )
}