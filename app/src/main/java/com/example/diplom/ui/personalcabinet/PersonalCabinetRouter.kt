package com.example.diplom.ui.personalcabinet

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class PersonalCabinetRouter @Inject constructor() {
    fun openStart(): Action {
        return Action.Navigate(
            PersonalCabinetFragmentDirections.actionPersonalCabinetFragmentToLoginGraph()
        )
    }

    fun openEditProfile(): Action {
        return Action.Navigate(
            PersonalCabinetFragmentDirections.actionPersonalCabinetFragmentToEditProfileFragment()
        )
    }

    fun openCashAccount(): Action {
        return Action.Navigate(
            PersonalCabinetFragmentDirections.actionPersonalCabinetFragmentToCashAccountFragment()
        )
    }

    fun openCurrentEntry(isCurrent: Boolean): Action {
        return Action.Navigate(
            PersonalCabinetFragmentDirections.actionPersonalCabinetFragmentToEntryCurrentFragment(isCurrent)
        )
    }

}