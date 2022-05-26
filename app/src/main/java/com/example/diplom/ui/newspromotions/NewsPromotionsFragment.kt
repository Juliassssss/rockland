package com.example.diplom.ui.newspromotions

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.R
import com.example.diplom.databinding.MainFragmentBinding
import com.example.diplom.extantions.getName
import com.example.diplom.extantions.viewBinding
import com.example.diplom.model.News
import com.example.diplom.model.Promotions
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.model.ScreenState
import javax.inject.Inject

class NewsPromotionsFragment : BaseFragment(R.layout.main_fragment){

    private val binding by viewBinding(MainFragmentBinding::bind)
    private val viewModel by viewModels<NewsPromotionsViewModel>()

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var promotionsAdapter: PromotionsAdapter

    override fun onScreenCreation() {
        viewModel.init()
    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.newsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            itemAnimator = null

            adapter = newsAdapter.apply {
                detailClickHandler = {
                    viewModel.openDetail(it.id, true)
                }
            }
        }

        binding.promotionsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            itemAnimator = null

            adapter = promotionsAdapter.apply {
                detailClickHandler = {
                    viewModel.openDetail(it.id, false)
                }
            }

        }
    }

    override fun onBindViewModel()= viewModel.apply {
        this.inLoad.observe{screenState ->
            binding.stateDisplayerApp.initViewFromState(screenState)
        }

        this.news.observe{screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        newsAdapter.submitList(this)
                    }
                }
                else -> {
                }
            }
            binding.stateDisplayerNews.initViewFromState(screenState)
        }

        this.promotions.observe{screenState ->
            when (screenState) {
                is ScreenState.Success -> {
                    with(screenState.value) {
                        promotionsAdapter.submitList(this)
                    }
                }
                else -> {
                }
            }
            binding.stateDisplayerPromotions.initViewFromState(screenState)
        }

    }

    override val showHideBottomNavigation: Boolean get() = true
}