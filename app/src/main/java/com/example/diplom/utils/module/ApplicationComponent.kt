package com.example.diplom.utils.module

import com.example.diplom.ui.RockLandApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        StoragesModule::class,
        UseCaseModule::class,
        FragmentModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<RockLandApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: RockLandApp): ApplicationComponent
    }
}
