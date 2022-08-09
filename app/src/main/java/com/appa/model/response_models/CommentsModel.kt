package com.appa.model.response_models


data class CommentsModelItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)