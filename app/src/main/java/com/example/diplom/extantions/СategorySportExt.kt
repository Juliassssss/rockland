package com.example.diplom.extantions

import com.example.diplom.R
import com.example.diplom.model.СategorySport

fun СategorySport.getName() = when (this) {
    СategorySport.CANDIDATE -> R.string.candidate
    СategorySport.MASTER -> R.string.master
    СategorySport.FIRST -> R.string.first
    СategorySport.SECOND -> R.string.second
    СategorySport.THIRD -> R.string.third
    СategorySport.NONE -> R.string.none
}

fun СategorySport.getСategorySportByInt(id: Int) = when (id) {
    1 -> СategorySport.FIRST
    2 -> СategorySport.SECOND
    3 -> СategorySport.THIRD
    4 -> СategorySport.CANDIDATE
    5 -> СategorySport.MASTER
    else -> СategorySport.NONE
}

fun СategorySport.getInt() = when (this) {
    СategorySport.CANDIDATE ->4
    СategorySport.MASTER -> 5
    СategorySport.FIRST ->1
    СategorySport.SECOND -> 2
    СategorySport.THIRD -> 3
    СategorySport.NONE -> 6
}
