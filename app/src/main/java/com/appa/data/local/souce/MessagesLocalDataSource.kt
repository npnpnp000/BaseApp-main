package com.appa.data.local.souce

import com.appa.data.local.dao.MessageDao
import com.appa.model.entities.MessageEntity

class MessagesLocalDataSource(private val messagesDao : MessageDao) {

    suspend fun saveMessageEntity(messageEntity: MessageEntity) {
        messagesDao.saveMessage(messageEntity)
    }

    fun getAllMessages() = messagesDao.getAllMessagesList()
}