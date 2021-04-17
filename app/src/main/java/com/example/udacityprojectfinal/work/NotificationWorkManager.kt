package com.example.udacityprojectfinal.work

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.udacityprojectfinal.R

class NotificationWorkManager(context: Context, parameters: WorkerParameters) : Worker(
    context,
    parameters
) {

    companion object {
        const val WORK_NAME = "NotificationWorker"
    }

    private val PRIMARY_CHANNEL_ID = "primary_channel_id"
    private val NOTIFICATION_ID = 0

    private var notificationWorkManager: NotificationManager? = null

    override fun doWork(): Result {
        return try {
            createChannel()
            sendNotification()
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    private fun sendNotification() {
        val notificationBuild: NotificationCompat.Builder = getNotificationBuilder()

        notificationWorkManager?.notify(NOTIFICATION_ID, notificationBuild.build())
    }

    private fun getNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(applicationContext, PRIMARY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(applicationContext.getString(R.string.title_notification))
            .setContentText(applicationContext.getString(R.string.content_notification))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
    }

    private fun createChannel() {
        notificationWorkManager = applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                applicationContext.getString(R.string.notification_channel_name),
            NotificationManager.IMPORTANCE_HIGH)

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLACK
            notificationChannel.description = applicationContext.getString(R.string.notification_channel_name)

            notificationWorkManager?.createNotificationChannel(notificationChannel)
        }
    }
}