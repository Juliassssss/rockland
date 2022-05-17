package com.example.diplom.ui.castom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.example.diplom.R
import com.example.diplom.databinding.ItemEditProfileViewBinding
import com.example.diplom.databinding.ItemPersoneCabinetViewBinding

class EditProfileItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ItemEditProfileViewBinding.inflate(LayoutInflater.from(context))

    init {
        context.withStyledAttributes(attrs, R.styleable.EditProfileItem) {

            val nomination = getString(R.styleable.EditProfileItem_edit_profile_item_nomination)
            val data = getString(R.styleable.EditProfileItem_edit_profile_item_data)


            binding.nomination.text = nomination
            binding.date.text = data

        }
        addView(binding.root)
    }

    fun setData(data: String){
        binding.date.text = data
    }
}
