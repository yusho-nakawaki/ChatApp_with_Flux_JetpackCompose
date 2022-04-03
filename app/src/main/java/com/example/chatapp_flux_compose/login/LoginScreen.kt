package com.example.chatapp_flux_compose.login

import android.graphics.ImageDecoder
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp_flux_compose.R
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

        val context = LocalContext.current
        val initialImageBitmap = ImageBitmap.imageResource(id = R.drawable.ic_not_set_icon)
        var imageBitmap by remember { mutableStateOf(initialImageBitmap) }
        val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                val source = ImageDecoder.createSource(context.contentResolver,it)
                imageBitmap = ImageDecoder.decodeBitmap(source).asImageBitmap()
            }
        }
        UserIcon(
            imageBitmap,
            onUserIconTap = { launcher.launch("image/*") }
        )

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

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onUserIconTap = { /*TODO*/ }, onCreateAccount = {})
}