package com.example.diplom.ui.personalcabinet.editprofil.phone

import com.example.diplom.ui.base.BaseViewModel
import javax.inject.Inject

class EditPhoneViewModel  @Inject constructor(
    private val router: EditPhoneRouter
) : BaseViewModel() {

    fun openEnterCodePhone(newPhone: String) {
        navigate(router.openEnterCodePhone(newPhone))
    }

}