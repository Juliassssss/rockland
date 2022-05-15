package com.example.diplom.ui.main.data

interface ILogging {

    enum class Format(val pattern: String) {
        FORMAT_DATE_FILE("yyyyMMdd"),
        FORMAT_DATE_IN_LOG("yyyy-MM-dd hh:mm:ss")
    }

    fun getAllFiles(folder: String) : List<String>

    fun setLogFile(folder: String, file: String)

    fun write(message: String)

    fun delete()

    suspend fun getSendData() : ISendData

    fun getCurDateTime(format: Format) : String
}

interface ISendData
