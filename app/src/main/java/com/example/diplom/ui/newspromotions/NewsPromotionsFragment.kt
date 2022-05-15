package com.example.diplom.ui.newspromotions

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diplom.R
import com.example.diplom.databinding.MainFragmentBinding
import com.example.diplom.extantions.viewBinding
import com.example.diplom.model.News
import com.example.diplom.model.Promotions
import com.example.diplom.ui.base.BaseFragment
import javax.inject.Inject

class NewsPromotionsFragment : BaseFragment(R.layout.main_fragment){

    private val binding by viewBinding(MainFragmentBinding::bind)
    private val viewModel by viewModels<NewsPromotionsViewModel>()

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var promotionsAdapter: PromotionsAdapter

    override fun onScreenCreation() {

    }

    override fun onLayoutInit(savedInstanceState: Bundle?) {

        binding.newsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            itemAnimator = null

            adapter = newsAdapter.apply {
//                clickListener = {
//                    viewModel.openCreateAccount(it)
//                }
            }

        }

        binding.promotionsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            itemAnimator = null

            adapter = promotionsAdapter.apply {
//                clickListener = {
//                    viewModel.openCreateAccount(it)
//                }
            }

        }

    }

    override fun onBindViewModel()= viewModel.apply {

        newsAdapter.submitList(
            listOf(
                News(1," Изменение графика работы", "а а а а а а а а а а а а а а "),
                News(2," Изменение цен", "а а а а а а а а а а а а а а "),
                News(3," Изменение графика работы", "а а а а а а а а а а а а а а "),
                News(4," График работы на праздники", "а а а а а а а а а а а а а а "),
                News(5," Новые чемпионы", "а а а а а а а а а а а а а а "),
                News(6," Новость", "а а а а а а а а а а а а а а "),
                News(7," Новость", "а а а а а а а а а а а а а а "),
                News(8," Новость", "а а а а а а а а а а а а а а "),
            )
        )

        promotionsAdapter.submitList(
            listOf(
                Promotions(1," Снижение стоимости  абонементов", "а а а а а а а а а а а а а а "),
                Promotions(2," Скидки для семьи", "а а а а а а а а а а а а а а "),
                Promotions(3," Праздники с нами выгоднее", "а а а а а а а а а а а а а а "),
                Promotions(4," Снижение стоимости годовых абонементов", "а а а а а а а а а а а а а а "),
                Promotions(5," Скидки на подарки любимым", "а а а а а а а а а а а а а а "),
                Promotions(6," Снижение стоимости годовых абонементов", "а а а а а а а а а а а а а а "),
                Promotions(7," Снижение стоимости годовых абонементов", "а а а а а а а а а а а а а а "),
                Promotions(8," Снижение стоимости годовых абонементов", "а а а а а а а а а а а а а а "),
            )
        )

    }

    override val showHideBottomNavigation: Boolean get() = true
}