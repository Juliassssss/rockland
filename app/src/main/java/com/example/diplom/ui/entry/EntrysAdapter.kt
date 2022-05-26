package com.example.diplom.ui.entry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.R
import com.example.diplom.databinding.ItemCurrentEntryBinding
import com.example.diplom.model.Entry
import javax.inject.Inject

class EntrysAdapter @Inject constructor(
    val context: Context,
) : ListAdapter<Entry, EntryViewHolder>(EntryDiffUtil()) {

    var detailClickHandler: (View) -> Unit = {}
    private var isCurrent = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val binding = ItemCurrentEntryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EntryViewHolder(
            binding,
            context,
            detailClickHandler,
            isCurrent
        )
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setIsCurrent(current: Boolean) {
        isCurrent = current
    }
}

class EntryViewHolder(
    private val itemBinding: ItemCurrentEntryBinding,
    private val context: Context,
    private val detailClickHandler: (View) -> Unit,
    private val isCurrent: Boolean
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(entry: Entry) {
        itemBinding.title.text = entry.date
        itemBinding.start.setData(entry.startTime)
        itemBinding.end.setData(entry.endTime)
        itemBinding.payment.setData(entry.sumPay)
        itemBinding.start.setTitle("Начало")
        itemBinding.end.setTitle("Конец")
        itemBinding.payment.setTitle("К оплате")
        if (isCurrent) {
            itemBinding.icon.visibility = View.VISIBLE
            itemBinding.entryCancelStatus.visibility = View.GONE
            itemBinding.entryCarriedStatus.visibility = View.GONE
        } else {
            itemBinding.icon.visibility = View.GONE
            if (entry.isCarried) {
                itemBinding.payment.setTitle("Оплачено")
                itemBinding.entryCarriedStatus.visibility = View.VISIBLE
                itemBinding.entryCancelStatus.visibility = View.GONE
            } else {
                itemBinding.entryCarriedStatus.visibility = View.GONE
                itemBinding.entryCancelStatus.visibility = View.VISIBLE
            }

        }

        itemBinding.icon.setOnClickListener {
            val popupMenu = PopupMenu(itemBinding.icon.context, it)
            popupMenu.inflate(R.menu.current_entry_menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.reset_entry_menu -> {

                        true
                    }
                    R.id.remind_entry_menu -> {

                        true
                    }

                    else -> false
                }
            }
            popupMenu.show()
        }

    }
}

class EntryDiffUtil : DiffUtil.ItemCallback<Entry>() {
    override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
        return oldItem == newItem
    }
}
