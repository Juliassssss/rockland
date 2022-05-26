package com.example.diplom.ui.newspromotions.detail

import android.os.Bundle
import com.example.diplom.R
import com.example.diplom.databinding.DetailNewsStockFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.ui.base.BaseFragment
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.newspromotions.NewsPromotionsViewModel

class DetailNewsPromotionsFragment: BaseFragment(R.layout.detail_news_stock_fragment) {

    private val binding by viewBinding(DetailNewsStockFragmentBinding::bind)
    private val viewModel by viewModels<NewsPromotionsViewModel>()

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {
        binding.toolbarDetailNewsStock.setNavigationOnClickListener {
            viewModel.navigateBack()
        }
    }

    override fun onBindViewModel(): BaseViewModel = viewModel.apply {

    }

    override val showHideBottomNavigation: Boolean get() = true
}