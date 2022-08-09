package com.appa.dependency_injection

import com.appa.data.local.dao.MessageDao
import com.appa.database.MessageRoomDatabase
import com.appa.utils.application.App

object DaoModule {

    fun provideMessagesDao() : MessageDao{
        return MessageRoomDatabase.getDatabase(App.getApplicationContext()).messageDao()
    }
}