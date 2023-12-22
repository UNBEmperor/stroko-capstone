package com.stroke.stroke_ch2_ps208.data.local

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SharedPreferences private constructor(private val context: Context) {
    suspend fun saveToken(token: String) {
        context.dataStore.edit { settings ->
            settings[TOKEN] = token
        }
    }

    fun getToken(): Flow<String> {
        return context.dataStore.data.map { settings -> settings[TOKEN] ?: "" }
    }

    suspend fun deleteToken() {
        context.dataStore.edit { settings -> settings[TOKEN] = "" }
    }

    companion object {
        private val TOKEN = stringPreferencesKey("token")

        @SuppressLint("StaticFieldLeak")
        private var instance: SharedPreferences? = null

        fun getInstance(context: Context) = instance ?:
        synchronized(this) {
            instance ?: SharedPreferences(context)
        }.also { instance = it }
    }
}
