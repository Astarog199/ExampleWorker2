package com.example.exampleworker

import android.content.Context
import android.widget.Toast
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        try {
            withContext(Dispatchers.Main) {
                Toast.makeText(applicationContext, "Run", Toast.LENGTH_SHORT).show()
            }

            delay(10000)

            withContext(Dispatchers.Main) {
                Toast.makeText(applicationContext, "Complete", Toast.LENGTH_SHORT).show()
            }
            return Result.success()
        } finally {
            onStopped()
        }
    }
}