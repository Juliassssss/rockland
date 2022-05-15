package com.example.diplom.ui.authorizationregistration

import com.example.diplom.ui.base.BaseViewModel
import javax.inject.Inject

class AuthorizationRegistrationViewModel @Inject constructor(
    private val router: AuthorizationRegistrationRouter
) : BaseViewModel() {


    fun enterCode(phoneTitle: String, isRegistrate: Boolean) {
        navigate(router.openEnterCode(phoneTitle, isRegistrate))
    }


}

