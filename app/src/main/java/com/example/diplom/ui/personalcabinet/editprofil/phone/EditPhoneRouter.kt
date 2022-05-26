package com.example.diplom.ui.personalcabinet.editprofil.phone

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class EditPhoneRouter @Inject constructor() {

    fun openEnterCodePhone(phone: String): Action {
        return Action.Navigate(
            EditPhoneFragmentDirections.actionEditPhoneFragmentToEnterCodeGraph(
                phone,
                isRegistrate = false,
                isEdit = true
            )
        )
    }
}