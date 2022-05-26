package com.example.diplom.ui.entername

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.databinding.EnterNameFragmentBinding

class EnterNameFragment : BaseFragment(R.layout.enter_name_fragment) {

    private val binding by viewBinding(EnterNameFragmentBinding::bind)
    private val viewModel by viewModels<EnterNameViewModel>()

    private val args by navArgs<EnterNameFragmentArgs>()

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.enterNameToolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        binding.enterNameNextBtn.setOnClickListener {
            val name = binding.name.text
            if (name.isNullOrBlank())
                Toast.makeText(
                    context,
                    getString(R.string.error_enter_name_toast),
                    Toast.LENGTH_LONG
                )
                    .show()
            else
                viewModel.navigateNext(name.toString(), args.phoneTitle)
        }

    }

    override fun onBindViewModel() = viewModel.apply {

    }

}