package com.example.diplom.ui.personalcabinet.editprofil

import android.os.Bundle
import androidx.fragment.app.setFragmentResultListener
import com.example.diplom.R
import com.example.diplom.databinding.EditProfileFragmentBinding
import com.example.diplom.extantions.getInt
import com.example.diplom.extantions.getName
import com.example.diplom.extantions.viewBinding
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.ui.datepicker.DatePickerFragment
import com.example.diplom.ui.entercode.EnterCodeFragment
import com.example.diplom.utils.data.format.DateFormatManager
import java.util.*
import javax.inject.Inject

class EditProfileFragment : BaseFragment(R.layout.edit_profile_fragment) {

    private val binding by viewBinding(EditProfileFragmentBinding::bind)
    private val viewModel by viewModels<EditProfileViewModel>()

    private lateinit var userInfo: UserInfo
    private var date: Date? = null

    @Inject
    lateinit var dateFormatter: DateFormatManager

    override fun onScreenCreation() {
        viewModel.init()
    }

    private var localIsGender = false

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.toolbarEditProfile.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        binding.editNameBtn.setOnClickListener {
            viewModel.openEditName(userInfo.name, userInfo.lastName ?: "")
        }

        binding.editPhoneBtn.setOnClickListener {
            viewModel.openEditPhone(userInfo.phone)
        }

        binding.editGenderBtn.setOnClickListener {
            localIsGender = true
            viewModel.openEditUserInfo(true, userInfo.gender?.getInt())
        }

        binding.editSportsCategoryBtn.setOnClickListener {
            localIsGender = false
            viewModel.openEditUserInfo(false, userInfo.category?.getInt())
        }

        binding.editDateOfBirthBtn.setOnClickListener {
            viewModel.openDatePicker(date)
        }

        setFragmentResultListener(EditNameFragmentDialog.DIALOG_ID) { _, bundle ->
            val newName = bundle.getString(EditNameFragmentDialog.NAME_TYPE, "")
            val newLastName = bundle.getString(EditNameFragmentDialog.LAST_NAME_TYPE, "")

            viewModel.editNameUserInfo(newName, newLastName)
        }

        setFragmentResultListener(EnterCodeFragment.ACTION_ID) { _, bundle ->
            val newPhone = bundle.getString(EnterCodeFragment.NEW_PHONE, "")
            viewModel.editPhoneInfo(newPhone)
        }

        setFragmentResultListener(EditUserInfoFragmentDialog.DIALOG_ID) { _, bundle ->
            val isGender = bundle.getBoolean(EditUserInfoFragmentDialog.IS_GENDER, localIsGender)
            val idChoose = bundle.getInt(EditUserInfoFragmentDialog.CHOOSE, 0)

            if (isGender)
                viewModel.editGenderInfo(idChoose)
            else
                viewModel.editCategorySportInfo(idChoose)
        }

        setFragmentResultListener(DatePickerFragment.DATE_PICKER_ID) { _, bundle ->
            bundle
                .getSerializable(DatePickerFragment.KEY_SELECTION)
                ?.let { it as? Date }
                ?.let {
                    val formatBirthday = dateFormatter.formatBirthdayDate(it)
                    viewModel.editBirthdayInfo(formatBirthday)
                }
        }
    }

    override fun onBindViewModel(): BaseViewModel = viewModel.apply {
        this.user.observe { screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        userInfo = this!!
                        binding.editNameBtn.setData("$name $lastName")
                        this?.phone?.let { binding.editPhoneBtn.setData(it) }
                        if (this?.dateBirth == null)
                            binding.editDateOfBirthBtn.setData(getString(R.string.none))
                        else {
                            binding.editDateOfBirthBtn.setData(this.dateBirth!!)
                            date = dateFormatter.formatDate(this.dateBirth!!)
                        }

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
            binding.stateDisplayerApp.initViewFromState(screenState)
        }

        this.editInfo.observe { screenState ->
            binding.stateDisplayerApp.initViewFromState(screenState)
            if (screenState is ScreenState.Success) {
                viewModel.init()
            }
        }
    }

    override val showHideBottomNavigation: Boolean get() = true
}