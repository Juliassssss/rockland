package com.example.diplom.ui.splash

import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.utils.usecase.UserInfoUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter
) : BaseViewModel(){

    fun authAndReg (title: String,  isRegistrate: Boolean){
        navigate(router.openAuthAndReg(title, isRegistrate))
    }

}