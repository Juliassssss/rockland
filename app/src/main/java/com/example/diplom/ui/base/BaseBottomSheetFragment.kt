package com.example.diplom.ui.base

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.diplom.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseBottomSheetFragment(@LayoutRes val layout: Int) : BottomSheetDialogFragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onScreenCreation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater
            .cloneInContext(ContextThemeWrapper(activity, R.style.PopupThemes))
            .inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLayoutInit(savedInstanceState)
        onBindViewModel()
    }

    abstract fun onScreenCreation()

    abstract fun onLayoutInit(savedInstanceState: Bundle?)

    abstract fun onBindViewModel()

}
