package com.example.allsongsdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.allsongsdemo.databinding.RecyclerviewItemSongBinding

class SongListAdapter: ListAdapter<Song, SongListAdapter.SongItemViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongItemViewHolder {
        return SongItemViewHolder(RecyclerviewItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SongItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SongItemViewHolder(private var binding: RecyclerviewItemSongBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (song: Song) {
            binding.song = song
            binding.executePendingBindings()
        }
    }
}