package com.example.diplom.utils.module

import android.content.Context
import com.example.diplom.memoru.PreferencesStorageImpl
import com.example.diplom.utils.data.PreferencesStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StoragesModule {

    @Provides
    @Singleton
    fun providesKeyValueRepo(context: Context): PreferencesStorage = PreferencesStorageImpl(context)

}