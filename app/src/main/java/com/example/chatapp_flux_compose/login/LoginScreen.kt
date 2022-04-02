package com.example.chatapp_flux_compose.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatapp_flux_compose.data.UserData

@Composable
fun LoginScreen(
    onUserIconTap: () -> Unit,
    onCreateAccount: (UserData) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        UserIcon(onUserIconTap)

        Spacer(modifier = Modifier.height(40.dp))

        val (userName, setUserName) = remember { mutableStateOf("") }
        UserNameTextField(userName, setUserName)

        Spacer(modifier = Modifier.height(60.dp))

        CreateAccountButton(
            onCreateAccount = {
                if (userName.isNotEmpty()) {
                    onCreateAccount.invoke(UserData(userName, ""))
                }
            }
        )
    }
}
