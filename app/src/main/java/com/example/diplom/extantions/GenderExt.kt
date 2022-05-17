package com.example.diplom.extantions

import com.example.diplom.R
import com.example.diplom.model.Gender

fun Gender.getName() =  when (this){
    Gender.MALE -> R.string.candidate
    Gender.FEMALE -> R.string.master
    Gender.NONE -> R.string.none
}