package com.example.diplom.extantions

import androidx.navigation.NavController

fun NavController.navigateIfExists(direction: Int): Boolean {
    return currentDestination
        ?.getAction(direction)
        ?.let {
            navigate(direction)
            true
        } ?: false
}
