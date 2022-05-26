package com.example.diplom.ui.personalcabinet.editprofil

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.databinding.EditNameFragmentDialogBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseBottomSheetFragment

class EditNameFragmentDialog() :
    BaseBottomSheetFragment(R.layout.edit_name_fragment_dialog) {

    companion object {
        const val DIALOG_ID = "edit:name:dialog:id"
        const val NAME_TYPE = "dialog:name:type"
        const val LAST_NAME_TYPE = "dialog:last:name:type"
    }

    private val args by navArgs<EditNameFragmentDialogArgs>()

    val binding: EditNameFragmentDialogBinding by viewBinding(
        EditNameFragmentDialogBinding::bind
    )

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.nameEditText.setText(args.name)
        binding.lastNameEditText.setText(args.lastName)

        binding.nextBtn.setOnClickListener {
            val name = binding.nameEditText.text
            if (name.isNullOrBlank())
                Toast.makeText(
                    context,
                    getString(R.string.error_enter_name_toast),
                    Toast.LENGTH_LONG
                )
                    .show()
            else {
                setResultToFragment(
                    name.toString(),
                    binding.lastNameEditText.text.toString()
                )
                dismiss()
            }
        }

    }

    override fun onBindViewModel() {
    }

    private fun setResultToFragment(name: String, lastName: String) {
        parentFragmentManager.setFragmentResult(
            DIALOG_ID,
            Bundle().apply {
                putString(NAME_TYPE, name)
                putString(LAST_NAME_TYPE, lastName)
            }
        )
    }
}