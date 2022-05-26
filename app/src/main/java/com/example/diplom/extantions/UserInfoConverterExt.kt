package com.example.diplom.extantions

import com.example.diplom.model.UserInfo
import com.example.diplom.model.UserInfoEntity

fun UserInfo.toEntity() = UserInfoEntity(
    id,
    avatar,
    name,
    lastName,
    gender,
    phone,
    dateBirth,
    category
)

fun UserInfoEntity.fromEntity() = UserInfo(
    id,
    avatar,
    name,
    lastName,
    gender,
    phone,
    dateBirth,
    category
)