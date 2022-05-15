package com.example.diplom.extantions

import android.text.TextUtils
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.google.android.material.snackbar.Snackbar


fun Fragment.hideSoftKeyboard() {
    activity?.hideSoftKeyboard()
}

fun Fragment.showErrorSnack(
    message: String
) {
    showErrorSnack(view, message)
}

fun showErrorSnack(
    view: View?,
    message: String
) {
    view?.apply {
        val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
            .apply {
                setBackgroundTint(ResourcesCompat.getColor(resources, R.color.red, null))
                setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
            }

        val snackbarView = snackbar.view
        val textViewMessage =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView

        with(textViewMessage) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_16))
            maxLines = 3
            setLineSpacing(
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    7.0f,
                    resources.displayMetrics
                ),
                1.0f
            )
            ellipsize = TextUtils.TruncateAt.END
            text = message
        }
        snackbar.show()
    }
}