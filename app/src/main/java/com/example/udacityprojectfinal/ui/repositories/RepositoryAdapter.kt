package com.example.udacityprojectfinal.ui.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.udacityprojectfinal.databinding.ItemRepositoriesBinding
import com.example.udacityprojectfinal.model.Repository


class RepositoryAdapter : ListAdapter<Repository, RepositoryAdapter.RepositoryViewHolder>(DiffCallback) {

    class RepositoryViewHolder(private val binding: ItemRepositoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.repository = repository
            binding.executePendingBindings()
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(ItemRepositoriesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = getItem(position)
        holder.bind(repository)
    }

}
