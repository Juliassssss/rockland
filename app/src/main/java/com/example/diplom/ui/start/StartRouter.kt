package com.example.diplom.ui.start

import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class StartRouter @Inject constructor() {

    fun openLogin(): Action {
        return Action.Navigate(StartFragmentDirections.startToLogin())
    }

    fun openNews(): Action {
        return Action.Navigate(StartFragmentDirections.actionStartToNewsPromotionsGraph())
    }

}