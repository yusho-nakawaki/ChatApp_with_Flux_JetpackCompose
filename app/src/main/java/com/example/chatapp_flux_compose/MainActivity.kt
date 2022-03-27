package com.example.chatapp_flux_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp_flux_compose.login.LoginActivity
import com.example.chatapp_flux_compose.ui.theme.ChatApp_Flux_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApp_Flux_ComposeTheme {
                Surface {
                    MainActivityScreen {
                        startActivity(LoginActivity.createIntent(applicationContext))
                    }
                }
            }
        }
    }

}

@Composable
private fun MainActivityScreen(onClickGoLoginScreenListener: () -> Unit) {
    AllChatsScreen(onClickGoLoginScreenListener)
}
