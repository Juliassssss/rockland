package com.example.diplom.ui.entry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.model.Entry
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.EntryUseCase
import javax.inject.Inject

class EntryCurrentViewModel @Inject constructor(
    private val router: EntryCurrentRouter,
    private val useCase: EntryUseCase,
) : BaseViewModel() {

    private val _entry = MutableLiveData<ScreenState<List<Entry?>>>()
    val entry: LiveData<ScreenState<List<Entry?>>> = _entry

    fun init(){
        _entry.load {
            useCase.loadEntry()
        }
    }
}