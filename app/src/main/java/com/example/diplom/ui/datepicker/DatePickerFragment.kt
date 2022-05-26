package com.example.diplom.ui.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.diplom.R
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        const val KEY_SELECTION = "selection"
        const val DATE_PICKER_ID = "datePickerResult"
    }

    private val args: DatePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return context?.let { ctxt ->
            val currentDate = args.date

            val calendar = GregorianCalendar.getInstance()
            currentDate?.apply {
                calendar.time = this
            }

            DatePickerDialog(
                ctxt,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).apply {
               // setTitle(getString(R.string.enter_date))
                setOnShowListener {

                    getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(
                            ctxt,
                            R.color.blue_profile
                        )
                    )
                    getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(
                        ContextCompat.getColor(
                            ctxt,
                            R.color.blue_profile
                        )
                    )
                }
            }
        } ?: throw IllegalStateException("context is null")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = GregorianCalendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        parentFragmentManager.setFragmentResult(
            DATE_PICKER_ID,
            Bundle().apply {
                putSerializable(KEY_SELECTION, calendar.time)
            }
        )
    }
}