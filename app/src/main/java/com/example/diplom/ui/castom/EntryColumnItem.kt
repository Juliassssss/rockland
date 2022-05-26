package com.example.diplom.ui.castom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.example.diplom.R
import com.example.diplom.databinding.ItemCurrentEntryColumnBinding

class EntryColumnItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ItemCurrentEntryColumnBinding.inflate(LayoutInflater.from(context))

    init {
        context.withStyledAttributes(attrs, R.styleable.EditProfileItem) {
            val title = getString(R.styleable.EntryColumnItem_entry_column_title)
            val value = getString(R.styleable.EntryColumnItem_entry_column_value)

            binding.title.text = title
            binding.value.text = value

        }
        addView(binding.root)
    }

    fun setData(data: String){
        binding.value.text = data
    }

    fun setTitle(title: String){
        binding.title.text = title
    }
}
