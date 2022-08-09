package com.appa.view.fragment.dashboard.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.appa.databinding.CardMessgeBinding
import com.appa.model.entities.MessageEntity

class MessagesViewHolder(private val binding: CardMessgeBinding, view: View) : RecyclerView.ViewHolder(view) {

    fun bind(messageEntity: MessageEntity) {
        binding.titleTxt.text = messageEntity.message
    }
}