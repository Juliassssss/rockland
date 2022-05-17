package com.example.diplom.ui.personalcabinet.editprofil

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class EditProfileRouter @Inject constructor(){

    fun openEx(): Action{
        return Action.Navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToEx()
        )
    }
}