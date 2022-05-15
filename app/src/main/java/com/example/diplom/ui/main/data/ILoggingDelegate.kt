package com.example.diplom.ui.main.data

interface ILoggingDelegate {
    fun log(level: LevelLogging, message: String)
}

enum class LevelLogging {
    DEBUG,
    INFO,
    WARN,
    ERROR
}