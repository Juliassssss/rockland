package com.example.diplom.ui.entercode

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class EnterCodeRouter @Inject constructor() {




    fun openNews(): Action {
        return Action.Navigate(EnterCodeFragmentDirections.enterCodeToNewsPromotionsGraph())
    }

    fun openEnterName(phone: String): Action {
        return Action.Navigate(EnterCodeFragmentDirections.actionEnterCodeToEnterName(phone))
    }

}