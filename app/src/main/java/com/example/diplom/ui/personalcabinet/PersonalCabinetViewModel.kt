package com.example.diplom.ui.personalcabinet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.UserInfoUseCase
import javax.inject.Inject

class PersonalCabinetViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: PersonalCabinetRouter
) : BaseViewModel() {

    private val _user = MutableLiveData<ScreenState<UserInfo?>>()
    val user: LiveData<ScreenState<UserInfo?>> = _user

    private val _logout = MutableLiveData<ScreenState<Boolean>>()
    val logout: LiveData<ScreenState<Boolean>> = _logout

    fun init(){
        _user.load(){
            useCase.getUserInfoProfile()
        }
    }

    fun logout(){
        _logout.load() {
           useCase.logout()
        }
    }

}
