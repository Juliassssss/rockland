package com.example.diplom.ui.cashaccount

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.CashAccountFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.model.ScreenState

class CashAccountFragment : BaseFragment(R.layout.cash_account_fragment) {

    private val binding by viewBinding(CashAccountFragmentBinding::bind)
    private val viewModel by viewModels<CashAccountViewModel>()

    override fun onScreenCreation() {
        viewModel.init()
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.myCashToolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }
    }

    override fun onBindViewModel() = viewModel.apply {
        this.user.observe { screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        binding.myCashText.text =
                            getString(
                                R.string.my_cash_residual,
                                this?.account
                            )
                    }
                }
                else -> {
                }
            }
            binding.stateAccount.initViewFromState(screenState)
        }
    }

    override val showHideBottomNavigation: Boolean get() = true
}