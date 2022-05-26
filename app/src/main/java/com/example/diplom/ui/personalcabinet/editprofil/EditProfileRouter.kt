package com.example.diplom.ui.personalcabinet.editprofil

import com.example.diplom.ui.base.model.Action
import java.util.*
import javax.inject.Inject

class EditProfileRouter @Inject constructor() {

    fun openEditName(name: String, lastName: String): Action {
        return Action.Navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToEditNameDialog(name, lastName)
        )
    }

    fun openEditPhone(phone: String): Action {
        return Action.Navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToEditPhoneFragmentDialog(phone)
        )
    }

    fun openEditInfo(isGender: Boolean, idChoose: String): Action {
        return Action.Navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToEditUserInfoFragmentDialog(
                isGender,
                idChoose
            )
        )
    }

    fun openDatePicker(start: Date? = null): Action {
        return Action.Navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToDatepickerGraph(start)
        )
    }
}