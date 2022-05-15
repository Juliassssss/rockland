package com.example.diplom.model

data class UserInfo(
    val id: Long,
    val avatar: String? = null,
    var name: String,
    var lastName: String? = null,
    var gender: String? = null,
    var phone: String,
    var dateBirth: String? = null,
    var category: String? = null,
) {

}