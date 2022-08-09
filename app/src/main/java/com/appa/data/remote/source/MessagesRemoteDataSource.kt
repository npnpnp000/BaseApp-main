package com.appa.data.remote.source

import com.appa.data.remote.api.MessagesApi
import com.appa.model.response_models.CommentsModelItem

class MessagesRemoteDataSource(private val messagesApi: MessagesApi) {

    suspend fun getComments(): ArrayList<CommentsModelItem> {
        return messagesApi.getComments()
    }

}