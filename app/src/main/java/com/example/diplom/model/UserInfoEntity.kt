package com.example.diplom.model

import kotlinx.serialization.Serializable

@Serializable
class UserInfoEntity(
    val id: Long,
    val avatar: String? = null,
    var name: String,
    var lastName: String?,
    var gender: Gender = Gender.NONE,
    var phone: String,
    var dateBirth: String?,
    var category: СategorySport = СategorySport.NONE,
) : java.io.Serializable