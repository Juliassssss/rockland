package com.example.diplom.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.MainThread
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.diplom.R
import com.example.diplom.extantions.hideSoftKeyboard
import com.example.diplom.ui.base.model.Action
import com.example.diplom.ui.main.MainActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

@Suppress("TooManyFunctions")
abstract class BaseFragment(resource: Int) : Fragment(resource) {

    open val showHideBottomNavigation: Boolean
        get() = (parentFragment as? BaseFragment)?.showHideBottomNavigation ?: false

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainActivity: MainActivity?
        get() = activity as? MainActivity


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        onBeforeCreate()
        super.onCreate(savedInstanceState)
        onScreenCreation()
    }

    protected open fun onBeforeCreate() {

    }

    private fun initBackPressedLogic(viewModel: BaseViewModel) {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!onBackPressed()) {
                        viewModel.navigateBack()
                    }
                }
            }
        )
    }

    protected open fun onBackPressed(): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigationVisibility()
        onLayoutInit(savedInstanceState)
        onBindViewModel()
            .apply {
                observeNavActions()
                initBackPressedLogic(this)
            }
    }

    abstract fun onScreenCreation()

    abstract fun onLayoutInit(savedInstanceState: Bundle?)
    abstract fun onBindViewModel(): BaseViewModel

    private fun setupBottomNavigationVisibility() {
        mainActivity?.handleBottomNavigationVisibility(showHideBottomNavigation)
    }

    private fun BaseViewModel.observeNavActions() {
        this.navLiveEvent.observe { action ->
            hideSoftKeyboard()

            when (action) {
                is Action.Navigate -> findNavController().navigate(
                    action.directions,
                    action.navOptions
                )
                is Action.ToAuth -> dropStackToAuth()
                is Action.Deeplink -> findNavController().navigate(action.deepLinkRequest)
                is Action.Back -> {
                    if (!findNavController().popBackStack()) {
                        handleAppClosing()
                    }
                }
            }
        }
    }

    private fun dropStackToAuth() {
        findNavController().popBackStack(R.id.nav_graph, true)
        findNavController().navigate(buildAuthDeepLink())
    }

    private fun buildAuthDeepLink(): NavDeepLinkRequest {
        return NavDeepLinkRequest.Builder
            .fromUri(requireActivity().getString(R.string.deep_link_go_to_auth_value).toUri())
            .build()
    }

    // Вот тут возможно будет кастомный код на обработку закрытия приложения
    private fun handleAppClosing() {
        requireActivity().finish()
    }

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner, { t ->
            hideSoftKeyboard()
            block.invoke(t)
        })
    }

    @MainThread
    inline fun <reified VM : ViewModel> Fragment.viewModels() =
        createViewModelLazy(VM::class, { this.viewModelStore }, { viewModelFactory })

    @MainThread
    inline fun <reified VM : ViewModel> Fragment.activityViewModels() =
        createViewModelLazy(
            VM::class,
            { requireActivity().viewModelStore },
            {
                if (requireActivity() is BaseActivity) {
                    (requireActivity() as BaseActivity).viewModelFactory
                } else {
                    requireActivity().defaultViewModelProviderFactory
                }
            }
        )
}
