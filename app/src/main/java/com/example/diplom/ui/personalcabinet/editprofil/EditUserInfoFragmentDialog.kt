package com.example.diplom.ui.personalcabinet.editprofil

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.databinding.EditUserInfoDialogFragmentBinding
import com.example.diplom.extantions.getName
import com.example.diplom.extantions.viewBinding
import com.example.diplom.model.Gender
import com.example.diplom.model.СategorySport
import com.example.diplom.ui.base.BaseBottomSheetFragment

class EditUserInfoFragmentDialog() :
    BaseBottomSheetFragment(R.layout.edit_user_info_dialog_fragment) {

    companion object {
        const val DIALOG_ID = "edit:user:info:dialog:id"
        const val CHOOSE = "edit:user:info:id"
        const val IS_GENDER = "edit:user:info:is:gender"
    }

    private val args by navArgs<EditUserInfoFragmentDialogArgs>()

    val binding: EditUserInfoDialogFragmentBinding by viewBinding(
        EditUserInfoDialogFragmentBinding::bind
    )

    private var idChoose: Int = 0

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        if (args.isGender) {
            binding.titleEditUserInfo.text = getString(R.string.title_edit_gender)
            binding.fistCheckBox.text = getString(Gender.MALE.getName())
            binding.secondCheckBox.text = getString(Gender.FEMALE.getName())
            binding.thirdCheckBox.text = getString(Gender.NONE.getName())

            binding.fourthCheckBox.visibility = View.GONE
            binding.fifthCheckBox.visibility = View.GONE
            binding.sixthCheckBox.visibility = View.GONE
        } else {
            binding.titleEditUserInfo.text = getString(R.string.title_edit_sport_category)
            binding.fourthCheckBox.visibility = View.VISIBLE
            binding.fifthCheckBox.visibility = View.VISIBLE
            binding.sixthCheckBox.visibility = View.VISIBLE

            binding.fistCheckBox.text = getString(СategorySport.FIRST.getName())
            binding.secondCheckBox.text = getString(СategorySport.SECOND.getName())
            binding.thirdCheckBox.text = getString(СategorySport.THIRD.getName())
            binding.fourthCheckBox.text = getString(СategorySport.CANDIDATE.getName())
            binding.fifthCheckBox.text = getString(СategorySport.MASTER.getName())
            binding.sixthCheckBox.text = getString(СategorySport.NONE.getName())
        }

        idChoose = args.chooseId.toInt()

        when (idChoose) {
            1 -> binding.fistCheckBox.isChecked = true
            2 -> binding.secondCheckBox.isChecked = true
            3 -> setNoneGender()
            4 -> binding.fourthCheckBox.isChecked = true
            5 -> binding.fifthCheckBox.isChecked = true
            6 -> setNoneCategorySport()
        }

        binding.fistCheckBox.setOnClickListener {
            setFalseAll()
            binding.fistCheckBox.isChecked = true
            idChoose = 1
        }

        binding.secondCheckBox.setOnClickListener {
            setFalseAll()
            binding.secondCheckBox.isChecked = true
            idChoose = 2
        }

        binding.thirdCheckBox.setOnClickListener {
            setNoneGender()
        }

        binding.fourthCheckBox.setOnClickListener {
            setFalseAll()
            binding.fourthCheckBox.isChecked = true
            idChoose = 4
        }

        binding.fifthCheckBox.setOnClickListener {
            setFalseAll()
            binding.fifthCheckBox.isChecked = true
            idChoose = 5
        }

        binding.sixthCheckBox.setOnClickListener {
            setNoneCategorySport()
        }

        binding.resetBtn.setOnClickListener {
            if (args.isGender)
                setNoneGender()
            else
                setNoneCategorySport()
        }

        binding.nextBtn.setOnClickListener {
            setResultToFragment()
            dismiss()
        }

    }

    override fun onBindViewModel() {
    }

    private fun setFalseAll() {
        binding.fistCheckBox.isChecked = false
        binding.secondCheckBox.isChecked = false
        binding.thirdCheckBox.isChecked = false
        binding.fourthCheckBox.isChecked = false
        binding.fifthCheckBox.isChecked = false
        binding.sixthCheckBox.isChecked = false
    }

    private fun setNoneGender() {
        setFalseAll()
        binding.thirdCheckBox.isChecked = true
        idChoose = 3
    }

    private fun setNoneCategorySport() {
        setFalseAll()
        binding.sixthCheckBox.isChecked = true
        idChoose = 6
    }

    private fun setResultToFragment() {
        parentFragmentManager.setFragmentResult(
            DIALOG_ID,
            Bundle().apply {
                putInt(CHOOSE, idChoose)
                putBoolean(IS_GENDER, args.isGender)
            }
        )
    }
}