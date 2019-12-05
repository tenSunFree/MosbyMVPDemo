package com.home.mosbymvpdemo.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.mosbymvpdemo.databinding.ActivityMainListViewItemBinding
import com.home.mosbymvpdemo.main.model.entity.MainListEntity

class MainListAdapter : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    private val data = mutableListOf<MainListEntity>()
    var onItemClick: (MainListEntity) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainListViewItemBinding.inflate(layoutInflater, parent, false)
        val viewHolder = ViewHolder(binding)
        viewHolder.binding.constraintLayoutRoot.setOnClickListener { onItemClick(data[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].apply {
            holder.binding.textViewDate.text = this.date
            Glide.with(holder.binding.root.context).load(this.imageUrl)
                .into(holder.binding.imageView)
            holder.binding.textViewTitle.text = this.title
            holder.binding.textViewPrompt.text = this.prompt
        }
    }

    override fun getItemCount() = data.size

    fun updateNotes(data: MutableList<MainListEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun getNotesList() = data

    class ViewHolder(val binding: ActivityMainListViewItemBinding) : RecyclerView.ViewHolder(binding.root)
}