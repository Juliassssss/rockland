package com.example.diplom.utils.module

import com.example.diplom.ui.authorizationregistration.AuthorizationRegistrationFragment
import com.example.diplom.ui.entercode.EnterCodeFragment
import com.example.diplom.ui.entername.EnterNameFragment
import com.example.diplom.ui.personalcabinet.PersonalCabinetFragment
import com.example.diplom.ui.newspromotions.NewsPromotionsFragment
import com.example.diplom.ui.splash.SplashFragment
import com.example.diplom.ui.start.StartFragment
import com.example.diplom.ui.timetable.TimetableFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun splash(): SplashFragment

    @ContributesAndroidInjector
    abstract fun newsPromotions(): NewsPromotionsFragment

    @ContributesAndroidInjector
    abstract fun timetableFragment(): TimetableFragment

    @ContributesAndroidInjector
    abstract fun personalCabinetFragment(): PersonalCabinetFragment

    @ContributesAndroidInjector
    abstract fun authorizationRegistrationFragment(): AuthorizationRegistrationFragment

    @ContributesAndroidInjector
    abstract fun enterCodeFragment(): EnterCodeFragment

    @ContributesAndroidInjector
    abstract fun enterNameFragment(): EnterNameFragment

    @ContributesAndroidInjector
    abstract fun startFragment(): StartFragment

}
