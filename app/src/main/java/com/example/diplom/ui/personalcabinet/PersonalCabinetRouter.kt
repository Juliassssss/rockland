package com.example.diplom.ui.personalcabinet

import com.example.diplom.ui.base.model.Action
import com.example.diplom.ui.splash.SplashFragmentDirections
import javax.inject.Inject

class PersonalCabinetRouter @Inject constructor() {
    fun openStart(): Action {
        return Action.Navigate(
            PersonalCabinetFragmentDirections.actionPersonalCabinetFragmentToLoginGraph()
        )
    }
}