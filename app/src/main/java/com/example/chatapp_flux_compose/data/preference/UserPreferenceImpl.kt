package com.example.chatapp_flux_compose.data.preference

import android.content.Context

class UserPreferenceImpl(override val context: Context) : UserPreference {
    override val preferenceName = "UserPref"

    override var userId: String
        get() = read(Keys.USER_ID, "")
        set(value) = put(Keys.USER_ID, value)
    override var userName: String
        get() = read(Keys.USER_NAME, "")
        set(value) = put(Keys.USER_NAME, value)
    override var userIconUrl: String
        get() = read(Keys.USER_ICON_URL, "")
        set(value) = put(Keys.USER_ICON_URL, value)

    private object Keys {
        const val USER_ID = "USER_ID"
        const val USER_NAME = "USER_NAME"
        const val USER_ICON_URL = "USER_ICON_URL"
    }
}