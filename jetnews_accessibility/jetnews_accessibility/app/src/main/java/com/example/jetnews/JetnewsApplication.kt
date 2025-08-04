package com.example.jetnews

import android.app.Application
import com.example.jetnews.data.AppContainer
import com.example.jetnews.data.AppContainerImpl
import com.example.jetnews.data.DataStoreManager

class JetnewsApplication : Application() {
    val dataStoreManager by lazy { DataStoreManager(applicationContext) }

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}