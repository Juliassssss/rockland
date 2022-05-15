package com.example.diplom.utils.module

import com.example.diplom.utils.data.PreferencesStorage
import com.example.diplom.utils.usecase.UserInfoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun getUserInfoUseCase(prefStorage: PreferencesStorage): UserInfoUseCase =
        UserInfoUseCase(prefStorage)

}