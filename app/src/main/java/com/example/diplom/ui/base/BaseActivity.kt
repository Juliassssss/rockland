package com.example.diplom.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        onBindViewModel()
    }

//    private fun performDependencyInjection() {
//        AndroidInjection.inject(this)
//    }
//
//
//    @TargetApi(Build.VERSION_CODES.M)
//    fun hasPermission(permission: String): Boolean {
//        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
//    }
//
//    @TargetApi(Build.VERSION_CODES.M)
//    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(permissions, requestCode)
//        }
//    }
//
//    fun hideKeyboard() {
//        val view = this.currentFocus
//        if (view != null) {
//            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
//            imm?.hideSoftInputFromWindow(view.windowToken, 0)
//        }
//    }
//
//    fun hideLoading() {
//        if (mProgressDialog != null)
//            if (mProgressDialog!!.isShowing)
//                mProgressDialog?.cancel()
//
//    }
//
//    fun showLoading() {
//        hideLoading()
//        mProgressDialog = AppUtils.showLoadingDialog(this)
//    }
//
//    fun isNetworkConnected(): Boolean {
//        return AppUtils.isNetworkConnected(applicationContext)
//    }
//
//    fun showMessage(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    fun onError(message: String?) {
//        if (message != null) {
//            showSnackBar(message)
//        } else {
//            showSnackBar(getString(R.string.some_error))
//        }
//    }
//
//    private fun showSnackBar(message: String) {
//        val snackbar = Snackbar.make(
//            findViewById(android.R.id.content),
//            message, Snackbar.LENGTH_SHORT
//        )
//        val sbView = snackbar.view
//        val textView = sbView
//            .findViewById<View>(R.id.snackbar_text) as TextView
//        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
//        snackbar.show()
//    }

    /**
     * В этом методе производить подписки на изменения значений в LiveData у ViewModel
     */
    abstract fun onBindViewModel()

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseActivity, { t -> block.invoke(t) })
    }

}
