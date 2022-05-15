package com.example.diplom.ui.newspromotions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diplom.R
import com.example.diplom.databinding.ItemNewsRvBinding
import com.example.diplom.model.News
import javax.inject.Inject

class NewsAdapter @Inject constructor(
    val context: Context
) : ListAdapter<News, NewsViewHolder>(NewsDiffUtil()) {

    var detailClickHandler: (News) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(
            binding,
            context,
            detailClickHandler
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsViewHolder(
    private val itemBinding: ItemNewsRvBinding,
     private val context: Context,
    private val detailClickHandler: (News) -> Unit,
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(new: News) {

        with(itemBinding) {
//            new.image?.let {
//                Glide
//                    .with(context)
//                    .load(it)
//                    .into(img)
//            }
            title.text = new.title
        }


    }
}

class NewsDiffUtil : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}
