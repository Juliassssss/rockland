package com.example.diplom.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.example.diplom.R
import com.example.diplom.databinding.ItemPersoneCabinetViewBinding

class PersoneCabinetItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ItemPersoneCabinetViewBinding.inflate(LayoutInflater.from(context))

    init {
        context.withStyledAttributes(attrs, R.styleable.PersoneCabinetItem) {
            val color = getColor(
                R.styleable.PersoneCabinetItem_personal_cabinet_color,
                context.resources.getColor(R.color.black)
            )
            val icon = getDrawable(R.styleable.PersoneCabinetItem_persone_cabinet_item_title_icon)
            val text = getString(R.styleable.PersoneCabinetItem_persone_cabinet_item_title)
            val summa = getString(R.styleable.PersoneCabinetItem_persone_cabinet_item_summa)

            binding.icon.setImageDrawable(icon)
            binding.text.text = text
            binding.text.setTextColor(color)
            binding.summa.text = summa
        }
        addView(binding.root)
    }
}
