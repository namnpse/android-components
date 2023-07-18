package com.namnp.androidcomponents.service.foreground_service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.namnp.androidcomponents.R


class RunningService: Service() {

    // bound service, 1 service instance, multiple components bound to it
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() { // foreground services need UI (notification)
        // 0 -> error -> 1,2,3,...
        val channelId = "running_channel"
        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Run is active")
            .setContentText("Elapsed time: 00:50")
            .build()
        startForeground(1, notification)
    }

    enum class Actions {
        START, STOP
    }

}