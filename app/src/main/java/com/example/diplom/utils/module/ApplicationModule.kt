package com.example.diplom.utils.module

import android.content.Context
import com.example.diplom.ui.RockLandApp
import com.example.diplom.utils.data.ILocalResourcesProvider
import com.example.diplom.utils.data.LocalResourceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    fun provideContext(app: RockLandApp): Context = app.applicationContext


    @Provides
    @Singleton
    fun provideLocalResourceProvider(context: Context): ILocalResourcesProvider =
        LocalResourceProvider(context)

}