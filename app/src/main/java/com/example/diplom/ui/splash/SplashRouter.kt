package com.example.diplom.ui.splash

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class SplashRouter @Inject constructor() {

    fun openAuthAndReg(title: String, isRegistrate: Boolean): Action {
        return Action.Navigate(
            SplashFragmentDirections.actionSplashToAuthReg(title, isRegistrate)
        )
    }
}