package com.example.chatapp_flux_compose.login

import android.graphics.ImageDecoder
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.example.chatapp_flux_compose.R
import com.example.chatapp_flux_compose.data.UserData
import com.example.chatapp_flux_compose.data.general.StatusState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    onUserIconTap: (ImageBitmap) -> Unit,
    onCreateAccount: (UserData) -> Unit,
    store: LoginStore,
) {

    LaunchedEffect(Unit) {
        launch {
//            store.statusState
        }
    }

    val statusState = store.statusState.collectAsState()

    Box {
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
                    onUserIconTap.invoke(imageBitmap)
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

        if (statusState.value.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x22000000))
            ) {
                CircularProgressIndicator(color = Color.DarkGray)
            }
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
//    LoginScreen(onUserIconTap = { /*TODO*/ }, onCreateAccount = {})
}