package com.example.chatapp_flux_compose.data.preference

import android.content.Context
import android.content.SharedPreferences
import java.util.HashSet

interface RootPreference {
    val context: Context
    val preferenceName: String
    val sharedPreference: SharedPreferences
        get() = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

    fun read(key: String, default: Boolean) = sharedPreference.getBoolean(key, default)
    fun read(key: String, default: Int) = sharedPreference.getInt(key, default)
    fun read(key: String, default: Long) = sharedPreference.getLong(key, default)
    fun read(key: String, default: Float) = sharedPreference.getFloat(key, default)
    fun read(key: String, default: String) = sharedPreference.getString(key, default) ?: ""
    fun read(key: String, default: Set<String>): Set<String> = sharedPreference.getStringSet(key, default) ?: HashSet()

    fun put(key: String, default: Boolean) = sharedPreference.edit().putBoolean(key, default).apply()
    fun put(key: String, default: Int) = sharedPreference.edit().putInt(key, default).apply()
    fun put(key: String, default: Long) = sharedPreference.edit().putLong(key, default).apply()
    fun put(key: String, default: Float) = sharedPreference.edit().putFloat(key, default).apply()
    fun put(key: String, default: String) = sharedPreference.edit().putString(key, default).apply()
    fun put(key: String, default: Set<String>) = sharedPreference.edit().putStringSet(key, default).apply()

    fun remove(key: String) = sharedPreference.edit().remove(key).apply()

    fun clear() {
        sharedPreference.edit().clear().apply()
    }
}