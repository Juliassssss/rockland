package com.example.diplom.ui.personalcabinet.editprofil.phone

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.databinding.EditPhoneFragmentDialogBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.BaseViewModel

class EditPhoneFragment() :
    BaseFragment(R.layout.edit_phone_fragment_dialog) {

    private val args by navArgs<EditPhoneFragmentArgs>()

    val binding: EditPhoneFragmentDialogBinding by viewBinding(
        EditPhoneFragmentDialogBinding::bind
    )
    private val viewModel by viewModels<EditPhoneViewModel>()

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.editPhoneEditText.setText(args.phone)

        binding.nextBtn.setOnClickListener {
            val phone = binding.editPhoneEditText.text
            if (phone!!.trim().length != 17)
                Toast.makeText(
                    context,
                    getString(R.string.error_enter_name_toast),
                    Toast.LENGTH_LONG
                )
                    .show()
            else {

                viewModel.openEnterCodePhone(phone.toString())
            }
        }

    }

    override fun onBindViewModel(): BaseViewModel = viewModel.apply {

    }

}