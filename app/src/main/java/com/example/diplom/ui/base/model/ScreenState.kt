package com.example.diplom.ui.base.model

import android.content.Context
import com.example.diplom.extantions.ParsedError
import com.example.diplom.extantions.parseError

sealed class ScreenState<R>(val tag: String) {

    class Loading<R>(tag: String) : ScreenState<R>(tag)
    class Success<R>(val value: R, tag: String) : ScreenState<R>(tag)
    class Failure<R>(
        val throwable: Throwable,
        tag: String
    ) : ScreenState<R>(tag) {
        fun parsedError(context: Context) = throwable.parseError(context)
    }

    companion object {

        fun <R> loading(tag: String): ScreenState<R> = Loading(tag)
        fun <R> success(value: R, tag: String): ScreenState<R> =
            Success(value, tag)

        fun <R> failure(
            throwable: Throwable,
            tag: String
        ): ScreenState<R> =
            Failure(throwable, tag)
    }

    val isLoading: Boolean get() = this is Loading

    val isSuccess: Boolean get() = this is Success

    val isFailure: Boolean get() = this is Failure

    inline fun doOnSuccess(operation: (R) -> Unit) {
        when (this) {
            is Loading -> {
            }
            is Failure -> {
            }
            is Success -> operation(value)
        }
    }

    inline fun doOnLoading(operation: () -> Unit) {
        when (this) {
            is Loading -> operation()
            is Failure -> {
            }
            is Success -> {

            }
        }
    }

    inline fun doOnFailure(context: Context, operation: (ParsedError) -> Unit) {
        when (this) {
            is Loading -> {
            }
            is Failure -> operation(throwable.parseError(context))
            is Success -> {
            }
        }
    }

    inline fun <C> fold(
        ifLoading: () -> C,
        ifFailure: (t: Throwable) -> C,
        ifSuccess: (R) -> C
    ): C = when (this) {
        is Loading -> ifLoading()
        is Failure -> ifFailure(throwable)
        is Success -> ifSuccess(value)
    }
}
