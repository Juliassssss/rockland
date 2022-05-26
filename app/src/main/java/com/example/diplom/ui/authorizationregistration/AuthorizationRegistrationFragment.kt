package com.example.diplom.ui.authorizationregistration

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.databinding.AuthorizationRegistrationFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment

class AuthorizationRegistrationFragment :
    BaseFragment(R.layout.authorization_registration_fragment) {

    private val binding by viewBinding(AuthorizationRegistrationFragmentBinding::bind)
    private val viewModel by viewModels<AuthorizationRegistrationViewModel>()

    private val args by navArgs<AuthorizationRegistrationFragmentArgs>()

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.authRegToolbar.title = args.title

        binding.authRegToolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        binding.authRegNextBtn.setOnClickListener {

            val phone = binding.phone.text

            if (phone!!.trim().length != 17) {
                Toast.makeText(context, getString(R.string.error_enter_phone_toast), Toast.LENGTH_LONG)
                    .show()
            } else
                viewModel.enterCode(phone.toString(), args.isRegistrate)

        }

    }

    override fun onBindViewModel() = viewModel.apply {

    }
}