package com.example.diplom.utils.module

import com.example.diplom.utils.data.PreferencesStorage
import com.example.diplom.utils.usecase.EntryUseCase
import com.example.diplom.utils.usecase.NewsAndStockUseCase
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

    @Provides
    @Singleton
    fun getNewsAndStockUseCase(): NewsAndStockUseCase =
        NewsAndStockUseCase()

    @Provides
    @Singleton
    fun getEntryUseCase(prefStorage: PreferencesStorage): EntryUseCase =
        EntryUseCase(prefStorage)

}