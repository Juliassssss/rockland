package com.example.diplom.utils.data

/**
 * Interface was made for local resources getting (labels, dimens)
 * */
interface ILocalResourcesProvider {
    /*check ids with ios*/
    fun getString(id: Int): String
    fun getStringByStringId(id: String): String
    fun getInteger(id: Int): Int
    fun getStringFormatted(id: Int, vararg args: Any): String

}
