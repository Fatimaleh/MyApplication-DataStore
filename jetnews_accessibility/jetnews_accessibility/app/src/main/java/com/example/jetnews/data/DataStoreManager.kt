package com.example.jetnews.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "jetnews_prefs")

class DataStoreManager(private val context: Context) {
    companion object {
        private val EXAMPLE_KEY = stringPreferencesKey("example_key")
    }

    suspend fun saveExample(value: String) {
        context.dataStore.edit { preferences ->
            preferences[EXAMPLE_KEY] = value
        }
    }

    fun getExample(): Flow<String> {
        return context.dataStore.data
            .map { preferences -> preferences[EXAMPLE_KEY] ?: "default" }
    }
}