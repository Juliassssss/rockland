package com.example.diplom.ui.entercode

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import android.os.CountDownTimer
import android.widget.Toast
import com.example.diplom.databinding.EnterCodFragmentBinding
import java.lang.String
import java.util.*

class EnterCodeFragment : BaseFragment(R.layout.enter_cod_fragment) {

    private val binding by viewBinding(EnterCodFragmentBinding::bind)
    private val viewModel by viewModels<EnterCodeViewModel>()

    private val args by navArgs<EnterCodeFragmentArgs>()

    companion object {
        const val ACTION_ID = "enter:code:fragment:id"
        const val NEW_PHONE = "enter:code:fragment:new:phone"
    }

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.enterCodeToolbar.title = args.phoneTitle

        binding.enterCodeToolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        val countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.newCodeBtn.setText(
                    String.format(
                        Locale.getDefault(),
                        getString(R.string.new_code),
                        (millisUntilFinished / 1000L).toString()
                    )
                )
            }

            override fun onFinish() {
                setBlueBtn()
            }
        }.start()

        binding.newCodeBtn.setOnClickListener {
            setGreyBtn()
            countDownTimer.start()
        }

        binding.nextBtn.setOnClickListener {
            if (binding.code.text!!.length == 6) {
                if (args.isEdit) {
                    setResultToFragment()
                    countDownTimer.cancel()
                    viewModel.navigateBack()
                    viewModel.navigateBack()
                } else {
                    countDownTimer.cancel()
                    viewModel.navigateNext(args.isRegistrate, args.phoneTitle)
                }

            } else
                Toast.makeText(
                    context,
                    getString(R.string.error_enter_code_toast),
                    Toast.LENGTH_LONG
                )
                    .show()

        }

    }

    override fun onBindViewModel() = viewModel.apply {

    }

    private fun setBlueBtn() {
        binding.newCodeBtn.isClickable = true
        binding.newCodeBtn.text = getString(R.string.new_code_get)
        binding.newCodeBtn.setBackgroundColor(resources.getColor(R.color.blue))
        binding.newCodeBtn.setTextColor(resources.getColor(R.color.white))
    }

    private fun setGreyBtn() {
        binding.newCodeBtn.isClickable = false
        binding.newCodeBtn.setBackgroundColor(resources.getColor(R.color.grey_button))
        binding.newCodeBtn.setTextColor(resources.getColor(R.color.grey_text))
    }

    private fun setResultToFragment() {
        parentFragmentManager.setFragmentResult(
            ACTION_ID,
            Bundle().apply {
                putString(NEW_PHONE, args.phoneTitle)
            }
        )
    }
}