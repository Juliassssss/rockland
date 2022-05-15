package com.example.diplom.ui.newspromotions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.databinding.ItemNewsRvBinding
import com.example.diplom.databinding.ItemStockRvBinding
import com.example.diplom.model.News
import com.example.diplom.model.Promotions
import javax.inject.Inject

class PromotionsAdapter @Inject constructor(
    val context: Context
) : ListAdapter<Promotions, PromotionsViewHolder>(PromotionsDiffUtil()) {

    var detailClickHandler: (Promotions) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionsViewHolder {
        val binding = ItemStockRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PromotionsViewHolder(
            binding,
            context,
            detailClickHandler
        )
    }

    override fun onBindViewHolder(holder: PromotionsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PromotionsViewHolder(
    private val itemBinding: ItemStockRvBinding,
    private val context: Context,
    private val detailClickHandler: (Promotions) -> Unit,
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(promotions: Promotions) {

        with(itemBinding) {
//            new.image?.let {
//                Glide
//                    .with(context)
//                    .load(it)
//                    .into(img)
//            }
            title.text = promotions.title
        }


    }
}

class PromotionsDiffUtil : DiffUtil.ItemCallback<Promotions>() {
    override fun areItemsTheSame(oldItem: Promotions, newItem: Promotions): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Promotions, newItem: Promotions): Boolean {
        return oldItem == newItem
    }
}
