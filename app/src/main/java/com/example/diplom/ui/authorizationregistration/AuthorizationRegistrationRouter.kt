package com.example.diplom.ui.authorizationregistration

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class AuthorizationRegistrationRouter @Inject constructor() {

    fun openEnterCode(phoneTitle: String, isRegistrate: Boolean): Action {
        return Action.Navigate(
            AuthorizationRegistrationFragmentDirections.actionAuthRegToEnterCode(
                phoneTitle,
                isRegistrate
            )
        )
    }
}


