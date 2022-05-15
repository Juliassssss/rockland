package com.example.diplom.ui.base.model

import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

sealed class Action {
    data class Navigate(val directions: NavDirections, val navOptions: NavOptions? = null) :
        Action()

    class Deeplink(val deepLinkRequest: NavDeepLinkRequest) : Action()
    class Intent(val intent: android.content.Intent) : Action()

    object Back : Action()
    object ToAuth : Action()

}
