package com.example.diplom.ui.cashaccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.UserInfoUseCase
import javax.inject.Inject

class CashAccountViewModel @Inject constructor(
    private val router: CashAccountRouter,
    private val useCase: UserInfoUseCase,
) : BaseViewModel() {

    private val _user = MutableLiveData<ScreenState<UserInfo?>>()
    val user: LiveData<ScreenState<UserInfo?>> = _user

    fun init() {
        _user.load {
            useCase.getUserInfoProfile()
        }
    }
}