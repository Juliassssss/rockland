package com.example.diplom.utils.data

import com.example.diplom.model.UserInfo

/**
 * Interface for key-value storage such as user session and other stuff
 *
 * */
interface PreferencesStorage {
    fun clear(): Boolean
    fun clearOnLogout(): Boolean

    fun storeProfile(profile: UserInfo)
    fun getUserProfileStart(): UserInfo?
    fun getUserProfile(): UserInfo

    fun getUpdatingDate(): Long {
        return -1L
    }


}
