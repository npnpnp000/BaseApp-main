package com.appa.data.remote.api

import com.appa.model.response_models.CommentsModelItem
import retrofit2.http.GET

interface MessagesApi {

    @GET("/comments")
    suspend fun getComments(): ArrayList<CommentsModelItem>
}