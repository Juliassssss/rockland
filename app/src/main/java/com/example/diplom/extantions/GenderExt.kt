package com.example.diplom.extantions

import com.example.diplom.R
import com.example.diplom.model.Gender

fun Gender.getName() = when (this) {
    Gender.MALE -> R.string.male
    Gender.FEMALE -> R.string.female
    Gender.NONE -> R.string.none
}

fun Gender.getGenderByInt(id: Int) = when (id) {
    1 -> Gender.MALE
    2 -> Gender.FEMALE
    else -> Gender.NONE
}

fun Gender.getInt() = when (this) {
    Gender.MALE -> 1
    Gender.FEMALE -> 2
    Gender.NONE -> 3
}