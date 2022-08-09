package com.appa.utils.application

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {

        private var instance : App? = null
        fun getApplicationContext() : Context = instance!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


//    private val database by lazy { MessageRoomDatabase.getDatabase(this@App) }
//    private val webService by lazy { MessagesRemoteDataSource() }
//    // A variable for repository.
//    val messagesRepository by lazy { MessagesRepository(database.messageDao(), webService) }
}