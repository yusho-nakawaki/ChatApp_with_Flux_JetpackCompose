package com.example.chatapp_flux_compose.data.preference

import android.content.Context
import androidx.compose.ui.input.key.Key

class UserPreferenceImpl(override val context: Context) : UserPreference {
    override val preferenceName = "UserPref"

    override var USER_ID: String
        get() = read(Keys.USER_ID, "")
        set(value) = put(Keys.USER_ID, value)
    override var USER_NAME: String
        get() = read(Keys.USER_NAME, "")
        set(value) = put(Keys.USER_NAME, value)
    override var USER_ICON_URL: String
        get() = read(Keys.USER_ICON_URL, "")
        set(value) = put(Keys.USER_ICON_URL, value)

    private object Keys {
        const val USER_ID = "USER_ID"
        const val USER_NAME = "USER_NAME"
        const val USER_ICON_URL = "USER_ICON_URL"
    }
}