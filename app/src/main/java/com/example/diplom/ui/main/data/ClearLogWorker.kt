package com.example.diplom.ui.main.data

import android.content.Context
import androidx.work.*
import dagger.android.HasAndroidInjector
import java.util.concurrent.TimeUnit
import javax.inject.Inject

object ContextInjection {
    @JvmStatic
    fun inject(to: Any, with: Context) {
        (with.applicationContext as HasAndroidInjector).androidInjector().inject(to)
    }
}

class ClearLogWorker(appContext: Context, params: WorkerParameters):
    Worker(appContext, params) {

    @Inject
    lateinit var logUseCase: LogUseCase

    init {
        ContextInjection.inject(to = this, with = appContext)
    }

    companion object {

        private const val WORK_NAME = "ClearLogWorker"

        fun setupClearLogWorker(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .setRequiresCharging(true)
                .build()

            val repeatingRequest = PeriodicWorkRequestBuilder<ClearLogWorker>(1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                repeatingRequest
            )
        }
    }


    override fun doWork(): Result {
        return try {
            logUseCase.clear()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}