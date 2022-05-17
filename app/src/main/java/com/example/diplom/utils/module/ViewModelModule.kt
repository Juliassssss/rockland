package com.example.diplom.utils.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diplom.ui.authorizationregistration.AuthorizationRegistrationViewModel
import com.example.diplom.ui.entercode.EnterCodeViewModel
import com.example.diplom.ui.entername.EnterNameViewModel
import com.example.diplom.ui.personalcabinet.PersonalCabinetViewModel
import com.example.diplom.ui.main.MainActivityViewModel
import com.example.diplom.ui.newspromotions.NewsPromotionsViewModel
import com.example.diplom.ui.personalcabinet.editprofil.EditProfileViewModel
import com.example.diplom.ui.splash.SplashViewModel
import com.example.diplom.ui.start.StartViewModel
import com.example.diplom.ui.timetable.TimetableViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsPromotionsViewModel::class)
    abstract fun newsPromotionsViewModel(viewModel: NewsPromotionsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TimetableViewModel::class)
    abstract fun timetableViewModel(viewModel: TimetableViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonalCabinetViewModel::class)
    abstract fun personalCabinetViewModel(viewModel: PersonalCabinetViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationRegistrationViewModel::class)
    abstract fun authorizationRegistrationViewModel(viewModel: AuthorizationRegistrationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EnterCodeViewModel::class)
    abstract fun enterCodeViewModel(viewModel: EnterCodeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EnterNameViewModel::class)
    abstract fun enterNameViewModel(viewModel: EnterNameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun startViewModel(viewModel: StartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditProfileViewModel::class)
    abstract fun editProfileViewModel(viewModel: EditProfileViewModel): ViewModel

}