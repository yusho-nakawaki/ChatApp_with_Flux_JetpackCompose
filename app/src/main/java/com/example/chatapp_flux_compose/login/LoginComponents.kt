package com.example.chatapp_flux_compose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp_flux_compose.R

@Composable
fun UserIcon(
    imageBitmap: ImageBitmap,
    onUserIconTap: () -> Unit,
) {
    Box (
        modifier = Modifier.size(120.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "this image will be used in icon image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(60.dp)
                )
                .fillMaxSize()
                .clip(CircleShape)
                .clickable { onUserIconTap.invoke() }
        )
        Image(
            painter = painterResource(R.drawable.ic_plus_circle_black),
            contentDescription = "add your icon image",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserNameTextField(
    userName: String,
    onUserNameChanged: (String) -> Unit,
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(text = "ユーザー名:", fontSize = 15.sp)

        val keyboardController = LocalSoftwareKeyboardController.current
        TextField(
            value = userName,
            onValueChange = onUserNameChanged,
            modifier = Modifier.size(200.dp, 50.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()})
        )
    }
}

@Composable
fun CreateAccountButton (
    onCreateAccount: () -> Unit,
) {
    Button(
        onClick = { onCreateAccount.invoke() },
        modifier = Modifier
            .wrapContentHeight()
            .width(200.dp)
            .padding(10.dp)
    ) {
        Text(text = "Create new account")
    }
}