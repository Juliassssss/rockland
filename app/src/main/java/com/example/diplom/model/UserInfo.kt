package com.example.diplom.model

data class UserInfo(
    val id: Long,
    val avatar: String? = null,
    var name: String,
    var lastName: String? = "",
    var gender: Gender? = Gender.NONE,
    var phone: String,
    var dateBirth: String? = null,
    var category: СategorySport? = СategorySport.NONE,
) {

}