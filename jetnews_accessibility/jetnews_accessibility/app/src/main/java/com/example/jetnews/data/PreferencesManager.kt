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

class PreferencesManager(private val context: Context) {
    companion object {
        val BOOKMARKED_POSTS_KEY = stringPreferencesKey("bookmarked_posts")
    }

    suspend fun saveBookmarks(postIds: String) {
        context.dataStore.edit { prefs ->
            prefs[BOOKMARKED_POSTS_KEY] = postIds
        }
    }

    fun getBookmarks(): Flow<String> {
        return context.dataStore.data
            .map { prefs -> prefs[BOOKMARKED_POSTS_KEY] ?: "" }
    }
}