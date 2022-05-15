package com.example.diplom.extantions

import android.content.Context
import com.example.diplom.R
import com.example.diplom.error.AppErrorKind
import com.example.diplom.error.AppLogicException

fun Throwable.parseError(context: Context): ParsedError {
    return when (this) {
        is AppLogicException -> this.parseAppErrorException(context)
        else -> GeneralError(
            DEFAULT_ERROR_CODE,
            "Ой, ошибочка",
            this.message ?: "none"
        )
    }
}

private fun AppLogicException.parseAppErrorException(context: Context): ParsedError {
    return when (this.appErrorKind) {
        AppErrorKind.NOT_AUTHORIZED -> GeneralError(
            LOGIC_ERROR_CODE,
            "Ошибка входа",
            "Повторите вход в приложение"
        )
        else -> {
            message?.let {
                GeneralError(
                    DEFAULT_ERROR_CODE,
                    "Ой, ошибочка",
                    it
                )
            } ?: GeneralError(
                DEFAULT_ERROR_CODE,
                "Ой, ошибочка",
                "Кажется, что-то пошло не так"
            )
        }
    }
}

inline fun <T> orNull(block: () -> T): T? = try {
    block.invoke()
} catch (exc: Throwable) {
    null
}

inline fun skipCatch(block: () -> Unit) =
    try {
        block()
    } catch (ext: Throwable) {
        //DO nothing
    }
