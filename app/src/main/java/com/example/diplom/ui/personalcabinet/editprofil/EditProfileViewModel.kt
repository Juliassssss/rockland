package com.example.diplom.ui.personalcabinet.editprofil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.extantions.getGenderByInt
import com.example.diplom.extantions.getСategorySportByInt
import com.example.diplom.model.Gender
import com.example.diplom.model.UserInfo
import com.example.diplom.model.СategorySport
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.UserInfoUseCase
import java.util.*
import javax.inject.Inject

class EditProfileViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: EditProfileRouter
) : BaseViewModel() {

    private val _user = MutableLiveData<ScreenState<UserInfo?>>()
    val user: LiveData<ScreenState<UserInfo?>> = _user

    private val _editInfo = MutableLiveData<ScreenState<Boolean?>>()
    val editInfo: LiveData<ScreenState<Boolean?>> = _editInfo

    fun init() {
        _user.load() {
            useCase.getUserInfoProfile()
        }
    }

    fun openEditName(name: String, lastName: String) {
        navigate(router.openEditName(name, lastName))
    }

    fun openEditPhone(phone: String) {
        navigate(router.openEditPhone(phone))
    }


    fun openEditUserInfo(isGender: Boolean, choose: Int?) {
        navigate(router.openEditInfo(isGender, choose?.toString() ?: "0"))
    }

    fun openDatePicker(currentDate: Date?) {
        navigate(router.openDatePicker(currentDate))
    }

    fun editNameUserInfo(name: String, lastName: String) {
        _editInfo.load {
            useCase.editName(name, lastName)
        }
    }

    fun editBirthdayInfo(newDate: String) {
        _editInfo.load {
            useCase.editDateBirth(newDate)
        }
    }

    fun editPhoneInfo(newPhone: String) {
        _editInfo.load {
            useCase.editPhone(newPhone)
        }
    }

    fun editGenderInfo(newGenderId: Int) {
        _editInfo.load {
            useCase.editGender(Gender.NONE.getGenderByInt(newGenderId))
        }
    }

    fun editCategorySportInfo(newCategorySportId: Int) {
        _editInfo.load {
            useCase.editCategorySport(СategorySport.NONE.getСategorySportByInt(newCategorySportId))
        }
    }

}