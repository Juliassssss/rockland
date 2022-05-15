package com.example.diplom.ui.start

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.diplom.R
import com.example.diplom.databinding.StartFragmentBinding
import com.example.diplom.extantions.navigateIfExists
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import java.lang.String
import java.util.*

class StartFragment : BaseFragment(R.layout.start_fragment) {

    private val binding by viewBinding(StartFragmentBinding::bind)
    private val viewModel by viewModels<StartViewModel>()

    override fun onScreenCreation() {
        Handler(Looper.getMainLooper()).post {
            if (!navigateIfNeeded()) {
                viewModel.startSync()
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

    }

    override fun onBindViewModel() = viewModel.apply {

    }

}