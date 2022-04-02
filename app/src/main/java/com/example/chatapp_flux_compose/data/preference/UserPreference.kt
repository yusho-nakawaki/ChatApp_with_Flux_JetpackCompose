package com.example.chatapp_flux_compose.data.preference

interface UserPreference: RootPreference {
    var userId: String
    var userName: String
    var userIconUrl: String
}