package com.example.internetapiapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.internetapiapp.network.MarsItem

import com.example.internetapiapp.databinding.MarsItemCardBinding

class MarsAdapter() : ListAdapter<MarsItem, MarsAdapter.MarsViewHolder>(MarsDiffCallback()) {
    class MarsViewHolder(
        private val binding : MarsItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:MarsItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(
            MarsItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class MarsDiffCallback : DiffUtil.ItemCallback<MarsItem>() {
    override fun areItemsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
        return oldItem == newItem
    }
}




