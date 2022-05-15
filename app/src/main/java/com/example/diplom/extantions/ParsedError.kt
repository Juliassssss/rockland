package com.example.diplom.extantions

sealed class ParsedError(val code: Int, val title: String, val message: String)

const val DEFAULT_ERROR_CODE = 1
const val LOGIC_ERROR_CODE = 2

class UnknownHostExceptionError(code: Int, title: String, message: String) :
    ParsedError(code, title, message)

class NetworkError(val httpCode: Int, code: Int, title: String, message: String) :
    ParsedError(code, title, message)

class GeneralError(code: Int, title: String, message: String) : ParsedError(code, title, message)
