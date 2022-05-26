package com.example.diplom.ui.entry

import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.R
import com.example.diplom.databinding.CurrentEntryFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.model.ScreenState
import javax.inject.Inject

class EntryCurrentFragment : BaseFragment(R.layout.current_entry_fragment) {

    private val binding by viewBinding(CurrentEntryFragmentBinding::bind)
    private val viewModel by viewModels<EntryCurrentViewModel>()

    private val args by navArgs<EntryCurrentFragmentArgs>()

    @Inject
    lateinit var entrysAdapter: EntrysAdapter

    override fun onScreenCreation() {
        viewModel.init()
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.currentEntryToolbar.title = getString(
            if (args.isCurrent)
                R.string.current_entry_title
            else
                R.string.history_entry_title
        )

        binding.currentEntryToolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }

        binding.currentEntryRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            itemAnimator = null

            adapter = entrysAdapter.apply {
                detailClickHandler = {
                    val popupMenu = PopupMenu(this.context!!, it)
                    popupMenu.inflate(R.menu.current_entry_menu)
                    popupMenu.show()
                }

            }
        }

    }

    override fun onBindViewModel() = viewModel.apply {
        this.entry.observe { screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        entrysAdapter.setIsCurrent(args.isCurrent)
                        entrysAdapter.submitList(this)
                    }
                }
                else -> {
                }
            }
            //  binding.stateDisplayerNews.initViewFromState(screenState)
        }

    }

    override val showHideBottomNavigation: Boolean get() = true
}