package com.example.diplom.utils.usecase

import com.example.diplom.error.AppLogicException
import com.example.diplom.model.Gender
import com.example.diplom.model.UserInfo
import com.example.diplom.model.СategorySport
import com.example.diplom.utils.data.PreferencesStorage

class UserInfoUseCase(private val prefStorage: PreferencesStorage) {

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun login(profile: UserInfo) {
        prefStorage.storeProfile(profile)
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun checkAuthAndClearSession(): Boolean {
        val hasAuth = prefStorage.getUserProfileStart()?.let { true } ?: false
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

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun editName(newName: String, newLastName: String): Boolean {
        val userInfo = prefStorage.getUserProfile()
        if (newName.isNotEmpty())
            userInfo.name = newName
        userInfo.lastName = newLastName
        prefStorage.storeProfile(userInfo)
        return true
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun editDateBirth(newDateBirth: String): Boolean {
        val userInfo = prefStorage.getUserProfile()
        userInfo.dateBirth = newDateBirth
        prefStorage.storeProfile(userInfo)
        return true
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun editPhone(newPhone: String): Boolean {
        val userInfo = prefStorage.getUserProfile()
        userInfo.phone = newPhone
        prefStorage.storeProfile(userInfo)
        return true
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun editGender(newGender: Gender): Boolean {
        val userInfo = prefStorage.getUserProfile()
        userInfo.gender = newGender
        prefStorage.storeProfile(userInfo)
        return true
    }

    @Throws(Throwable::class, AppLogicException::class)
    suspend fun editCategorySport(newCategorySport: СategorySport): Boolean {
        val userInfo = prefStorage.getUserProfile()
        userInfo.category = newCategorySport
        prefStorage.storeProfile(userInfo)
        return true
    }

}