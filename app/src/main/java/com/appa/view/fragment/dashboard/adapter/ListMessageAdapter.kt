package com.appa.view.fragment.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appa.databinding.CardMessgeBinding
import com.appa.model.entities.MessageEntity

class ListMessageAdapter : ListAdapter<MessageEntity, MessagesViewHolder>(ListMessageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val binding = CardMessgeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessagesViewHolder(binding, binding.root)
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ListMessageDiffCallback : DiffUtil.ItemCallback<MessageEntity>() {
        override fun areItemsTheSame(oldItem: MessageEntity, newItem: MessageEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessageEntity, newItem: MessageEntity): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }
}

