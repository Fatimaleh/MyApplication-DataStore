package com.example.jetnews.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "jetnews_settings")

class DataStoreHelper(private val context: Context) {
    suspend fun saveTestValue(value: String) {
        context.dataStore.edit { prefs ->
            prefs[stringPreferencesKey("TEST_KEY")] = value
        }
    }

    fun getTestValue(): Flow<String> {
        return context.dataStore.data
            .map { prefs -> prefs[stringPreferencesKey("TEST_KEY")] ?: "Valor padrão" }
    }
}