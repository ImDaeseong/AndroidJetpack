package com.daeseong.gameinfo_test

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import java.util.*

class GameCheckService : Service() {

    private val TAG = GameCheckService::class.java.simpleName

    private val handler = Handler(Looper.getMainLooper()) { msg ->
        Toast.makeText(applicationContext, msg.obj.toString(), Toast.LENGTH_SHORT).show()
        true
    }

    private var timer: Timer? = null

    private fun closeTimer() {
        try {
            timer?.cancel()
            timer = null
        } catch (e: Exception) {
            // Handle exception
        }
    }

    private fun startTimer() {

        closeTimer()

        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                val gameItems = GameInfo.getGameApp(this@GameCheckService)
                for (element in gameItems) {
                    val msg = handler.obtainMessage()
                    msg.what = 0
                    msg.obj = element.packageName
                    handler.sendMessage(msg)
                }
            }
        }, 0, 1000)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        // 포그라운드 서비스를 시작하고 알림을 표시
        val notification = createNotification()
        startForeground(1, notification)

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        startTimer()
    }

    override fun onDestroy() {
        super.onDestroy()

        try {
            closeTimer()
            handler.removeMessages(0)
        } catch (e: Exception) {
            // Handle exception
        }
    }

    private fun createNotification(): Notification {

        val channelId = "알림 채널 ID"
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle("서비스 제목")
            .setContentText("서비스 설명")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Android 8.0 이상에서는 알림 채널을 생성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "알림 채널 이름", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        return notificationBuilder.build()
    }
}
