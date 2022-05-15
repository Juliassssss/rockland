package com.example.diplom.ui.entercode

import androidx.lifecycle.viewModelScope
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.utils.usecase.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EnterCodeViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: EnterCodeRouter
) : BaseViewModel() {

    fun navigateNext(isRegistrate: Boolean, phone: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val action = if (isRegistrate) router.openEnterName(phone) else router.openNews()
            useCase.login(UserInfo(id = 1, name = "Юля", phone = phone))
            delay(3000)
            withContext(Dispatchers.Main) {
                navigate(action)
            }
        }

    }

}