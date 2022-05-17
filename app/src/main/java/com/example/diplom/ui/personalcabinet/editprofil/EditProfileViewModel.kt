package com.example.diplom.ui.personalcabinet.editprofil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.model.UserInfo
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.UserInfoUseCase
import javax.inject.Inject

class EditProfileViewModel @Inject constructor(
    private val useCase: UserInfoUseCase,
    private val router: EditProfileRouter
) : BaseViewModel(){

    private val _user = MutableLiveData<ScreenState<UserInfo?>>()
    val user: LiveData<ScreenState<UserInfo?>> = _user

    fun init(){
        _user.load(){
            useCase.getUserInfoProfile()
        }
    }

    fun openEx(){
        navigate(router.openEx())
    }

}