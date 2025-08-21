package com.route.e_commerce.core.data.store

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.route.e_commerce.core.data.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class DataStoreManager(private val dataStore: DataStore<Preferences>) {

    companion object {
        const val TAG = "DataStoreManager"
        val USER_ENTITY = stringPreferencesKey("user_entity")
    }

    suspend fun saveUser(user: UserEntity) {
        val json = Json.encodeToString(user)
        dataStore.edit { prefs ->
            prefs[USER_ENTITY] = json
        }
        Log.e(TAG, "User saved: $user, JSON: $json")
    }

    fun getUser(): Flow<UserEntity?> = dataStore.data.map { prefs ->
        prefs[USER_ENTITY]?.let { json ->
            try {
                val userEntity = Json.decodeFromString<UserEntity>(json)
                Log.e(TAG, "User loaded: $userEntity")
                userEntity
            } catch (e: Exception) {
                Log.e(TAG, "Error loading user: ${e.localizedMessage}")
                null
            }
        }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
        Log.e(TAG, "DataStore cleared")
    }
}