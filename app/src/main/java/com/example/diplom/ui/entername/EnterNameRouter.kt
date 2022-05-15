package com.example.diplom.ui.entername

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class EnterNameRouter @Inject constructor() {

    fun openNews(): Action {
        return Action.Navigate(EnterNameFragmentDirections.enterNameToNewsPromotionsGraph())
    }

}