package com.example.diplom.ui.splash

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import android.os.Handler
import android.os.Looper
import com.example.diplom.R
import com.example.diplom.databinding.SplashFragmentBinding
import com.example.diplom.extantions.navigateIfExists
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment

class SplashFragment : BaseFragment(R.layout.splash_fragment){

    private val binding by viewBinding(SplashFragmentBinding::bind)
    private val viewModel by viewModels<SplashViewModel>()

    override fun onScreenCreation() {
        Handler(Looper.getMainLooper()).post {
            if (!navigateIfNeeded()) {

            }
        }

    }

    private fun navigateIfNeeded(): Boolean {
        return findNavController()
            .previousBackStackEntry
            ?.let {
                findNavController().navigateIfExists(it.destination.id)
            }
            ?: false
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.registrationBtn.setOnClickListener{
            viewModel.authAndReg(getString(R.string.registration_title), true)
        }

        binding.authorizationBtn.setOnClickListener{
            viewModel.authAndReg(getString(R.string.authorization_title), false)
        }
    }

    override fun onBindViewModel() = viewModel.apply {

    }
}