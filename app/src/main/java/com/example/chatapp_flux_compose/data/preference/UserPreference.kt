package com.example.chatapp_flux_compose.data.preference

interface UserPreference: RootPreference {
    var USER_ID: String
    var USER_NAME: String
    var USER_ICON_URL: String
}