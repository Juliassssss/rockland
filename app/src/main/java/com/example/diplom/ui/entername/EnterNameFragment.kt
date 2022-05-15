package com.example.diplom.ui.entername

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.databinding.EnterNameFragmentBinding
import com.example.diplom.ui.entercode.EnterCodeFragmentArgs

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
            viewModel.navigateNext(binding.name.text.toString(), args.phoneTitle)
        }

    }

    override fun onBindViewModel() = viewModel.apply {

    }

}