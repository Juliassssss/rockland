package com.example.diplom.ui.castom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.annotation.LayoutRes
import com.example.diplom.R
import com.example.diplom.extantions.ParsedError
import com.example.diplom.ui.base.model.ScreenState

class StateDisplayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ViewFlipper(context, attrs) {

    @LayoutRes
    private val errorView: Int = R.layout.view_error

    @LayoutRes
    private val loadingView: Int = R.layout.view_load

    private lateinit var errorHeader: TextView
    private lateinit var errorMessage: TextView
    private lateinit var retryButton: Button

    private var retryCallback: (() -> Unit) = {}

    init {
        initView()
    }

    companion object {
        private const val LOADING_STATE = 0
        private const val ERROR_STATE = 1
        private const val CONTENT_STATE = 2
    }

    private fun initView() {
        val layoutInflater = LayoutInflater.from(context)

        initLoadingView(layoutInflater)
        initErrorView(layoutInflater)
    }

    private fun initLoadingView(layoutInflater: LayoutInflater) {
        val loadingView = layoutInflater.inflate(loadingView, this, false)
        addView(loadingView)
    }

    private fun initErrorView(layoutInflater: LayoutInflater) {
        val errorView = layoutInflater.inflate(errorView, this, false)
        addView(errorView)

        errorHeader = errorView.findViewById(R.id.texViewHeader)
        retryButton = errorView.findViewById(R.id.buttonRetry)
        retryButton.setOnClickListener {
            retryCallback.invoke()
        }
    }

    fun initViewFromState(state: ScreenState<*>) {
        when (state) {
            is ScreenState.Loading -> setLoadingState()
            is ScreenState.Failure -> setErrorState(state.parsedError(context))
            is ScreenState.Success -> setContentState()
        }
    }

    fun setContentState() {
        this.displayedChild = CONTENT_STATE
    }

    fun setLoadingState() {
        this.displayedChild = LOADING_STATE
    }

    fun setErrorState(parsedError: ParsedError) {
        this.displayedChild = ERROR_STATE
        this.errorHeader.text = parsedError.title
        this.errorMessage.text = parsedError.message
    }

    fun retryCallback(retryButtonText: String? = null, callback: () -> Unit) {
        this.retryCallback = callback
        retryButtonText
            ?.let {
                retryButton.text = it
            }
    }


}