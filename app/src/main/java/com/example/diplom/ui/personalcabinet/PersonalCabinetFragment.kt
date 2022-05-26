package com.example.diplom.ui.personalcabinet

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.PersonalCabinetFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.model.ScreenState

class PersonalCabinetFragment : BaseFragment(R.layout.personal_cabinet_fragment) {

    private val binding by viewBinding(PersonalCabinetFragmentBinding::bind)
    private val viewModel by viewModels<PersonalCabinetViewModel>()

    override fun onScreenCreation() {
        viewModel.init()
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.logOut.setOnClickListener {
            viewModel.logout()
        }

        binding.profileEditBtn.setOnClickListener {
            viewModel.openEdit()
        }

        binding.myScoreBtn.setOnClickListener {
            viewModel.openCashAccount()
        }

        binding.currentEntriesBtn.setOnClickListener {
            viewModel.openCurrentEntry(true)
        }

        binding.visitHistoryBtn.setOnClickListener {
            viewModel.openCurrentEntry(false)
        }
    }

    override fun onBindViewModel() = viewModel.apply {

        this.user.observe { screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        binding.name.text = "${this?.name} ${this?.lastName}"
                        binding.myScoreBtn.setSumma(
                            getString(
                                R.string.my_cash_residual,
                                this?.account
                            )
                        )
//
////                        this?.avatar?.let {
////                            Glide
////                                .with(requireContext())
////                                .load(it)
////                                .into(binding.avatar)
////                        }
                    }
                }
                else -> {
                }
            }
            binding.stateDisplayerApp.initViewFromState(screenState)
        }

        this.logout.observe {
            binding.stateDisplayerApp.initViewFromState(it)
            if (it is ScreenState.Success) {
                viewModel.toAuth()
            }
        }

    }

    override val showHideBottomNavigation: Boolean get() = true
}