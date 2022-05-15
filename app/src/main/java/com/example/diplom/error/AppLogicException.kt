package com.example.diplom.error

class AppLogicException(
    val appErrorKind: AppErrorKind,
    cause: Throwable? = null,
    message: String? = null,
) :
    Throwable(message, cause) {
}