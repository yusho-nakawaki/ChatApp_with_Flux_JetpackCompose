package com.example.chatapp_flux_compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.chatapp_flux_compose.login.LoginActivity

@Composable
fun AllChatsScreen(
    onClickGoLoginScreenListener: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { onClickGoLoginScreenListener() },
            modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "go to Login")
        }
    }
}