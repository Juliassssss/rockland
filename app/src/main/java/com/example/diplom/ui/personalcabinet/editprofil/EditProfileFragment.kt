package com.example.diplom.ui.personalcabinet.editprofil

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.EditProfileFragmentBinding
import com.example.diplom.extantions.getName
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState

class EditProfileFragment : BaseFragment(R.layout.edit_profile_fragment) {

    private val binding by viewBinding(EditProfileFragmentBinding::bind)
    private val viewModel by viewModels<EditProfileViewModel>()

    override fun onScreenCreation() {
        viewModel.init()
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.toolbarEditProfile.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        binding.editNameBtn.setOnClickListener {
            viewModel.openEx()
        }
    }

    override fun onBindViewModel(): BaseViewModel = viewModel.apply {
        this.user.observe { screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        binding.editNameBtn.setData("${this?.name} ${this?.lastName}")
                        this?.phone?.let { binding.editPhoneBtn.setData(it) }
                        if (this?.dateBirth == null)
                            binding.editDateOfBirthBtn.setData(getString(R.string.none))
                        else
                            binding.editDateOfBirthBtn.setData(this.dateBirth!!)
                        this?.gender?.let { binding.editGenderBtn.setData(getString(it.getName())) }
                        this?.category?.let { binding.editSportsCategoryBtn.setData(getString(it.getName())) }

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
            //binding.stateDisplayerApp.initViewFromState(screenState)
        }

    }

    override val showHideBottomNavigation: Boolean get() = true
}