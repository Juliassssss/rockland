package com.example.diplom.ui.base

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.EditNameFragmentDialogBinding
import com.example.diplom.extantions.viewBinding

class SingleActionChooser() :
    BaseBottomSheetFragment(R.layout.edit_name_fragment_dialog) {

    companion object {
        const val DIALOG_ID = "chooser:dialog:id"
        const val SELECTED_TYPE = "chooser:dialog:type"
    }

    val binding: EditNameFragmentDialogBinding by viewBinding(
        EditNameFragmentDialogBinding::bind
    )

    private fun setResultToFragment() {
//        parentFragmentManager.setFragmentResult(
//            DIALOG_ID,
//            Bundle().apply { putSerializable(SELECTED_TYPE, PopupAction.SuccessResult(type)) }
//        )
    }

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
//        binding.textViewAction.setOnClickListener {
//            setResultToFragment(ChooserTaskData(args.taskId, args.action))
//            dismiss()
//        }
//
//        binding.textViewAction.text = args.title
    }

    override fun onBindViewModel() {
    }
}
