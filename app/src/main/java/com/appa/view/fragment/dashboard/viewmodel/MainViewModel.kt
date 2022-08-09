package com.appa.view.fragment.dashboard.viewmodel

import androidx.lifecycle.*
import com.appa.data.repositories.MessagesRepository
import com.appa.model.entities.MessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val messagesRepository: MessagesRepository) : ViewModel() {

    var allMessagesLiveData: MutableLiveData<List<MessageEntity>?> = MutableLiveData<List<MessageEntity>?>()

    init {
        getAllMessages()
        addFakeData()
    }

    private fun addFakeData() {
        val randomNumber = (0..100).random().toString()
        val messageEntity = MessageEntity(randomNumber)
        saveMessageEntity(messageEntity)
    }

    private fun getAllMessages() = viewModelScope.launch {
        messagesRepository.getAllMessages().collect {
            allMessagesLiveData.value = it
        }
    }

    private fun saveMessageEntity(messageEntity: MessageEntity) = viewModelScope.launch(Dispatchers.IO) {
        messagesRepository.saveMessageEntity(messageEntity)
    }
}


