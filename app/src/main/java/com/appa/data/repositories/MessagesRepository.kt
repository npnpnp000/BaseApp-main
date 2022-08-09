package com.appa.data.repositories

import com.appa.data.local.souce.MessagesLocalDataSource
import com.appa.data.remote.source.MessagesRemoteDataSource
import com.appa.model.entities.MessageEntity


class MessagesRepository(
    private val messagesLocalDataSource : MessagesLocalDataSource,
    private val messagesRemoteDataSource: MessagesRemoteDataSource,
) {

    suspend fun getComments() = messagesRemoteDataSource.getComments()


    suspend fun saveMessageEntity(messageEntity: MessageEntity) {
        messagesLocalDataSource.saveMessageEntity(messageEntity)
    }

    fun getAllMessages() = messagesLocalDataSource.getAllMessages()

}