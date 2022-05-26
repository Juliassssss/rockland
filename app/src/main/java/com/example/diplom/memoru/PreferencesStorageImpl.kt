package com.example.diplom.memoru

import com.example.diplom.extantions.fromEntity
import com.example.diplom.extantions.toEntity
import com.example.diplom.model.UserInfo
import com.example.diplom.model.UserInfoEntity
import com.example.diplom.utils.data.PreferencesStorage
import kotlinx.serialization.decodeFromString
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PreferencesStorageImpl constructor(context: Context) : PreferencesStorage {

    companion object {
        const val COMMON_INFO = "pref:common"
        const val USER_SPECIFIC_INFO = "pref:user:specific"
        const val PROFILE_KEY = "pref:profile:key"
    }

    private val prefUser: SharedPreferences =
        context.getSharedPreferences(USER_SPECIFIC_INFO, Context.MODE_PRIVATE)
    private val prefUserIndependent: SharedPreferences =
        context.getSharedPreferences(COMMON_INFO, Context.MODE_PRIVATE)

    @SuppressLint("ApplySharedPref")
    override fun clear(): Boolean {
        prefUser.edit().clear().commit()
        prefUserIndependent.edit().clear().commit()
        return true
    }

    @SuppressLint("ApplySharedPref")
    override fun clearOnLogout(): Boolean {
        prefUser.edit().clear().commit()
        return true
    }

    override fun storeProfile(profile: UserInfo) {
        val encodeToString = Json.encodeToString(profile.toEntity())
        prefUser.edit().putString(PROFILE_KEY, encodeToString).apply()
    }

    override fun getUserProfile(): UserInfo {
        return prefUser.getString(PROFILE_KEY, null)
            ?.takeIf { it.isNotEmpty() }
            ?.let {
                return@let Json
                    .decodeFromString<UserInfoEntity>(it)
                    .fromEntity()
            }!!
    }

    override fun getUserProfileStart(): UserInfo? {
        return prefUser.getString(PROFILE_KEY, null)
            ?.takeIf { it.isNotEmpty() }
            ?.let {
                return@let Json
                    .decodeFromString<UserInfoEntity>(it)
                    .fromEntity()
            }
    }


}