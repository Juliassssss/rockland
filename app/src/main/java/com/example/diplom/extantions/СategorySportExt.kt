package com.example.diplom.extantions

import com.example.diplom.R
import com.example.diplom.model.СategorySport

fun СategorySport.getName() =  when (this){
    СategorySport.CANDIDATE -> R.string.candidate
    СategorySport.MASTER -> R.string.master
    СategorySport.FIRST -> R.string.first
    СategorySport.SECOND -> R.string.second
    СategorySport.THIRD -> R.string.third
    СategorySport.NONE -> R.string.none
}

