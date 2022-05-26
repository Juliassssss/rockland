package com.example.diplom.utils.module

import com.example.diplom.ui.authorizationregistration.AuthorizationRegistrationFragment
import com.example.diplom.ui.cashaccount.CashAccountFragment
import com.example.diplom.ui.personalcabinet.editprofil.EditNameFragmentDialog
import com.example.diplom.ui.entercode.EnterCodeFragment
import com.example.diplom.ui.entername.EnterNameFragment
import com.example.diplom.ui.entry.EntryCurrentFragment
import com.example.diplom.ui.personalcabinet.PersonalCabinetFragment
import com.example.diplom.ui.newspromotions.NewsPromotionsFragment
import com.example.diplom.ui.newspromotions.detail.DetailNewsPromotionsFragment
import com.example.diplom.ui.personalcabinet.editprofil.phone.EditPhoneFragment
import com.example.diplom.ui.personalcabinet.editprofil.EditUserInfoFragmentDialog
import com.example.diplom.ui.personalcabinet.editprofil.EditProfileFragment
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

    @ContributesAndroidInjector
    abstract fun editProfileFragment(): EditProfileFragment

    @ContributesAndroidInjector
    abstract fun singleActionChooser(): EditNameFragmentDialog

    @ContributesAndroidInjector
    abstract fun detailNewsPromotionsFragment(): DetailNewsPromotionsFragment

    @ContributesAndroidInjector
    abstract fun editUserInfoFragmentDialog(): EditUserInfoFragmentDialog

    @ContributesAndroidInjector
    abstract fun cashAccountFragment(): CashAccountFragment

    @ContributesAndroidInjector
    abstract fun entryCurrentFragment(): EntryCurrentFragment

    @ContributesAndroidInjector
    abstract fun editPhoneFragmentDialog(): EditPhoneFragment

}
