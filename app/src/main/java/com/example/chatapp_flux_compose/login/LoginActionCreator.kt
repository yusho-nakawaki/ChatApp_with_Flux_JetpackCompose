package com.example.chatapp_flux_compose.login

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import com.example.chatapp_flux_compose.data.architecture.Dispatcher
import com.example.chatapp_flux_compose.data.preference.UserPreference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.util.*

class LoginActionCreator(
    private val dispatcher: Dispatcher,
    private val userPreference: UserPreference,
) {

    fun uploadUserIconToStorage(userIcon: ImageBitmap) {
        dispatcher.dispatch(LoginActionEvent.LoadingStatusState)
        if (userPreference.userId == "") createUid()

        val bitmap = userIcon.asAndroidBitmap()
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val storageRef = Firebase.storage.reference
        val iconRef = storageRef.child("${userPreference.userId}/icon_image.jpg")
        val uploadTask = iconRef.putBytes(data)
        uploadTask.addOnSuccessListener { taskSnapshot ->
            val iconUrl = taskSnapshot.uploadSessionUri.toString()
            dispatcher.dispatch(LoginActionEvent.UploadUserIconSucceed(iconUrl))
        }.addOnFailureListener {
            dispatcher.dispatch(LoginActionEvent.UploadUserIconFailed(it.message))
        }
    }

    fun registerUserInfoToFirestore(userName: String) {
        dispatcher.dispatch(LoginActionEvent.LoadingStatusState)
        if (userPreference.userId == "") createUid()

        val db = Firebase.firestore
        val data = hashMapOf(
            "name" to userName,
            "iconUrl" to userPreference.userIconUrl
        )
        db.collection("basic_user_info").document(userPreference.userId)
            .set(data)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }

    private fun createUid() {
        val uid = UUID.randomUUID().toString()
        userPreference.userId = uid
    }

}