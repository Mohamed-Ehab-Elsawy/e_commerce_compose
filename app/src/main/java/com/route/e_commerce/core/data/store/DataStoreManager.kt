package com.route.e_commerce.core.data.store

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.data.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class DataStoreManager(private val dataStore: DataStore<Preferences>) {

    companion object {
        const val TAG = "DataStoreManager"
        val USER_ENTITY = stringPreferencesKey("user_entity")
        val CATEGORIES = stringPreferencesKey("categories")
        val NEW_ARRIVALS_PRODUCTS = stringPreferencesKey("new_arrivals_products")
        val SHOES_PRODUCTS = stringPreferencesKey("shoes_products")
        val ELECTRONICS_PRODUCTS = stringPreferencesKey("electronics_products")
    }

    suspend fun putUser(user: UserEntity) {
        val json = Json.encodeToString(user)
        dataStore.edit { prefs ->
            prefs[USER_ENTITY] = json
        }
        Log.e(TAG, "User saved: $user, JSON: $json")
    }

    fun fetchUser(): Flow<UserEntity?> = dataStore.data.map { prefs ->
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

    suspend fun putCategories(categories: List<CategoryEntity>) {
        val json = Json.encodeToString(categories)
        dataStore.edit { prefs ->
            prefs[CATEGORIES] = json
        }
        Log.e(TAG, "categories saved: $categories, JSON: $json")
    }

    fun fetchCategories(): Flow<List<CategoryEntity>?> = dataStore.data.map { prefs ->
        prefs[CATEGORIES]?.let { json ->
            try {
                val categories = Json.decodeFromString<List<CategoryEntity>>(json)
                Log.e(TAG, "categories loaded: $categories")
                categories
            } catch (e: Exception) {
                Log.e(TAG, "Error loading categories: ${e.localizedMessage}")
                null
            }
        }
    }

    suspend fun putProducts(products: List<ProductEntity>, key: Preferences.Key<String>) {
        val json = Json.encodeToString(products)
        dataStore.edit { prefs ->
            prefs[key] = json
        }
        Log.e(TAG, "categories saved: $products, JSON: $json")
    }

    fun fetchProducts(key: Preferences.Key<String>): Flow<List<ProductEntity>?> =
        dataStore.data.map { prefs ->
            prefs[key]?.let { json ->
                try {
                    val categories = Json.decodeFromString<List<ProductEntity>>(json)
                    Log.e(TAG, "products ${key.name} loaded: $categories")
                    categories
                } catch (e: Exception) {
                    Log.e(
                        TAG,
                        "Error loading products ${key.name}: ${e.localizedMessage}"
                    )
                    null
                }
            }
        }


    suspend fun clear() {
        dataStore.edit { it.clear() }
        Log.e(TAG, "DataStore cleared")
    }
}