package com.appa.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.appa.model.entities.MessageEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MessageDao {

    @Insert
    suspend fun saveMessage(messageEntity: MessageEntity)

    @Query("SELECT * FROM message_table ORDER BY id")
    fun getAllMessagesList() : Flow<List<MessageEntity>?>
}