package com.example.diplom.ui.main.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetupWorkManager {
    companion object {
        fun setup(context: Context) {
            CoroutineScope(Dispatchers.Default).launch {
                ClearLogWorker.setupClearLogWorker(context)
            }
        }
    }
}