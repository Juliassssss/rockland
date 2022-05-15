package com.example.diplom.utils.usecase

import com.example.diplom.error.AppLogicException
import com.example.diplom.model.UserInfo
import com.example.diplom.utils.data.PreferencesStorage


class UserInfoUseCase(private val prefStorage: PreferencesStorage) {

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun login(profile: UserInfo) {
        prefStorage.storeProfile(profile)
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun checkAuthAndClearSession(): Boolean {
        val hasAuth = prefStorage.getUserProfile()?.let { true } ?: false
        if (!hasAuth) {
            prefStorage.clearOnLogout()
        }
        return hasAuth
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun getUserInfoProfile(): UserInfo? {
        return prefStorage.getUserProfile()
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun logout(): Boolean {
       return prefStorage.clear()
    }

}