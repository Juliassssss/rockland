package com.example.diplom.ui.start

import androidx.lifecycle.viewModelScope
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.Action
import com.example.diplom.utils.usecase.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: StartRouter
) : BaseViewModel() {

    fun startSync() {
        viewModelScope.launch(Dispatchers.IO) {
            val action: Action = if (useCase.checkAuthAndClearSession()) {
                router.openNews()
            } else {
                router.openLogin()
            }
            delay(3000)
            withContext(Dispatchers.Main) {
                navigate(action)
            }
        }

    }

}