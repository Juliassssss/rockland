package com.example.diplom.ui.newspromotions

import android.app.Notification
import com.example.diplom.ui.base.model.Action
import javax.inject.Inject

class NewsPromotionsRouter @Inject constructor() {

    fun openDetail(id: Int, isNews: Boolean): Action {
        return Action.Navigate(
            NewsPromotionsFragmentDirections.actionNewsPromotionsFragmentToDetailNewsPromotionsFragment(
                isNews,
                id.toString()
            )
        )
    }
}