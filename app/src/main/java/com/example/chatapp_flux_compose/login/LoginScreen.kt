package com.example.chatapp_flux_compose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp_flux_compose.R

@Composable
fun LoginScreen(
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Box (
            modifier = Modifier.size(120.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            val imageBitMap = ImageBitmap.imageResource(R.drawable.ic_not_set_icon)
            Image(
                bitmap = imageBitMap,
                contentDescription = "this image will be used in icon image",
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = Gray,
                        shape = RoundedCornerShape(60.dp)
                    )
                    .fillMaxSize()
                    .clip(CircleShape)
                    .clickable { /* Todo */ }
            )
            Image(
                painter = painterResource(R.drawable.ic_plus_circle_black),
                contentDescription = "add your icon image",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(text = "ユーザー名:", fontSize = 15.sp)

            val (userName, setUserName) = rememberSaveable { mutableStateOf("") }
            TextField(
                value = userName,
                onValueChange = setUserName,
                modifier = Modifier.size(200.dp, 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .wrapContentHeight()
                .width(200.dp)
                .padding(10.dp)
        ) {
            Text(text = "Create new account")
        }
    }
}