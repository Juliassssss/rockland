package com.example.diplom.utils.data.format

import android.content.Context
import kotlinx.datetime.Instant
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatManager @Inject constructor(val context: Context) {

    companion object {
        val dateBirthdayFormat = SimpleDateFormat("dd MMMM yyyy")
    }

    fun formatBirthdayDate(date: Date?): String {
        return date?.let {
            dateBirthdayFormat.format(it)
        } ?: ""
    }

    private fun fromInstant(instant: Instant): Date {
        return Date(instant.toEpochMilliseconds())
    }

    fun formatDate(dateString: String): Date {
       return dateBirthdayFormat.parse(dateString)
    }

}