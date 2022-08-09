package com.appa.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_table")
data class MessageEntity(
    @ColumnInfo(name = "message") val message: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
