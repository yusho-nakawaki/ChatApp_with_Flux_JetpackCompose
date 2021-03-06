package com.example.chatapp_flux_compose.login

import android.graphics.ImageDecoder
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.unit.dp
import com.example.chatapp_flux_compose.R
import com.example.chatapp_flux_compose.data.general.StatusState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onUserIconTap: (ImageBitmap) -> Unit,
    onCreateAccount: (String) -> Unit,
    onRegisterBasicUserInfoSucceed: (Unit) -> Unit,
    store: LoginStore,
) {

    LaunchedEffect(Unit) {
        launch {
            store.registerBasicUserInfoSucceed.collect {
                onRegisterBasicUserInfoSucceed.invoke(it)
            }
        }
    }

    val statusState = store.statusState.collectAsState()
    val initialImageBitmap = ImageBitmap.imageResource(id = R.drawable.ic_not_set_icon)
    var imageBitmap by remember { mutableStateOf(initialImageBitmap) }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val source = ImageDecoder.createSource(context.contentResolver,it)
            imageBitmap = ImageDecoder.decodeBitmap(source).asImageBitmap()
            onUserIconTap.invoke(imageBitmap)
        }
    }

    Box {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

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
                        onCreateAccount.invoke(userName)
                    }
                }
            )
        }

        when (statusState.value) {
            is StatusState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0x22000000))
                ) {
                    CircularProgressIndicator(color = Color.DarkGray)
                }
            }
            is StatusState.Error -> {
                Toast.makeText(context, (statusState.value as StatusState.Error).errorMessage, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

}
