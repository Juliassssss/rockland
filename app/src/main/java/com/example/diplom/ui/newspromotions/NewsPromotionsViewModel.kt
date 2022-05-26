package com.example.diplom.ui.newspromotions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.diplom.model.News
import com.example.diplom.model.Promotions
import com.example.diplom.ui.base.BaseViewModel
import com.example.diplom.ui.base.model.ScreenState
import com.example.diplom.utils.usecase.NewsAndStockUseCase
import kotlinx.coroutines.delay
import javax.inject.Inject

class NewsPromotionsViewModel @Inject constructor(
    private val useCase: NewsAndStockUseCase,
    private val router: NewsPromotionsRouter
) : BaseViewModel() {

    private val _news = MutableLiveData<ScreenState<List<News?>>>()
    val news: LiveData<ScreenState<List<News?>>> = _news

    private val _promotions = MutableLiveData<ScreenState<List<Promotions?>>>()
    val promotions: LiveData<ScreenState<List<Promotions?>>> = _promotions

    private val _inLoad = MutableLiveData<ScreenState<Boolean?>>()
    val inLoad: LiveData<ScreenState<Boolean?>> = _inLoad

    fun init(){
        _inLoad.load {
            _news.load {
                useCase.loadNews()
            }

            _promotions.load {
                useCase.loadPromotions()
            }
            delay(4000)
            true
        }
    }

    fun openDetail(id: Int, isNews: Boolean){
        navigate(router.openDetail(id, isNews))
    }

}