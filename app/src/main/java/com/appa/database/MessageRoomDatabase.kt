package com.appa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appa.data.local.dao.MessageDao
import com.appa.model.entities.MessageEntity
import com.appa.utils.constants.DatabaseConstants.MESSAGES_DATABASE

@Database(entities = [MessageEntity::class], version = 1)
abstract class MessageRoomDatabase : RoomDatabase(){

    abstract fun messageDao() : MessageDao

    companion object {
        @Volatile
        private var INSTANCE: MessageRoomDatabase? = null

        fun getDatabase(context: Context): MessageRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MessageRoomDatabase::class.java,
                    MESSAGES_DATABASE
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    //TODO - check what solution is more appropriate for implementing a database
//    abstract fun basicApplicationDao () : BasicApplicationDao
//    companion object {
//
//        private var instance : BasicApplicationDatabase? = null
//
//        @Synchronized
//        fun getInstance(): BasicApplicationDatabase {
//            if (instance == null) {
//                instance = Room.databaseBuilder(App.applicationContext(), BasicApplicationDatabase::class.java, BASIC_APPLICATION_DATABASE)
//                    .fallbackToDestructiveMigration().build()
//            }
//            return instance!!
//        }
//    }
}