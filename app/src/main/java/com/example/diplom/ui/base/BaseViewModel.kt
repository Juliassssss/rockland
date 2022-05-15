package com.example.diplom.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplom.ui.base.model.Action
import com.example.diplom.ui.base.model.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    companion object {
        const val DEFAULT_TAG = "default_tag"
    }

    /** Все открытия экранов должны прохожить через эту лайфдату */
    private val _navigationLiveEvent = SingleLiveEvent<Action>()
    val navLiveEvent: LiveData<Action> = _navigationLiveEvent

    /** Если нужно снавигироваться из вью модели куда-то, то использовать этот метод */
    protected fun navigate(action: Action) {
        _navigationLiveEvent.value = action
    }

    /** Перейти на 1 экран назад по стеку фрагментов */
    fun navigateBack() {
        _navigationLiveEvent.value = Action.Back
    }


    fun toAuth() {
        _navigationLiveEvent.value = Action.ToAuth
    }

    protected fun <T> loadData(
        tag: String = DEFAULT_TAG,
        block: suspend () -> T
    ): Flow<ScreenState<T>> = flow {
        try {
            emit(ScreenState.loading(tag))
            emit(ScreenState.success(block(), tag))
        } catch (error: Throwable) {
            emit(ScreenState.failure<T>(error, tag = tag))
        }
    }

    protected fun <T> loadData(
        tag: String = DEFAULT_TAG,
        block: Flow<T>
    ): Flow<ScreenState<T>> = flow {
        try {
            emit(ScreenState.loading(tag))
            block.collect {
                emit(ScreenState.success(it, tag))
            }
        } catch (error: Throwable) {
            emit(ScreenState.failure<T>(error, tag = tag))
        }
    }

    protected fun <T> MutableLiveData<ScreenState<T>>.load(
        tag: String = DEFAULT_TAG,
        block: suspend () -> T,
    ): Job = viewModelScope
        .launch(Dispatchers.IO) {
            loadData(tag, block).collect { result -> this@load.postValue(result) }
        }

    protected fun <T> MutableLiveData<ScreenState<T>>.load(
        tag: String = DEFAULT_TAG,
        block: Flow<T>,
    ): Job = viewModelScope
        .launch(Dispatchers.IO) {
            loadData(tag, block).collect { result -> this@load.postValue(result) }
        }
}
