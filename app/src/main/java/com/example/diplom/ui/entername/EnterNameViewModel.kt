package com.example.diplom.ui.entername

import androidx.lifecycle.viewModelScope
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.utils.usecase.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EnterNameViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: EnterNameRouter
) : BaseViewModel() {

    fun navigateNext(name: String, phone: String) {

        viewModelScope.launch(Dispatchers.IO) {
            useCase.login(UserInfo(id = 1, name = name, phone = phone))
            delay(3000)
            withContext(Dispatchers.Main) {
                navigate(router.openNews())
            }
        }

    }

}