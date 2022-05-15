package com.example.diplom.extantions

import com.example.diplom.model.Gender
import com.example.diplom.model.UserInfo
import com.example.diplom.model.UserInfoEntity
import com.example.diplom.model.СategorySport


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