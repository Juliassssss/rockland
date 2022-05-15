package com.example.diplom.ui.timetable

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.TimetableFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment

class TimetableFragment : BaseFragment(R.layout.timetable_fragment){

    private val binding by viewBinding(TimetableFragmentBinding::bind)
    private val viewModel by viewModels<TimetableViewModel>()

    override fun onScreenCreation() {
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

    }

    override fun onBindViewModel() = viewModel.apply {

    }

    override val showHideBottomNavigation: Boolean get() = true
}
