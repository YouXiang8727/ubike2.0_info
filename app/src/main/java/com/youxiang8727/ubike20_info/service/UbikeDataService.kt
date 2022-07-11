package com.youxiang8727.ubike20_info.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.youxiang8727.ubike20_info.api.UbikeApiService
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class UbikeDataService @Inject constructor(
    val ubikeApiService: UbikeApiService
    ) : Service() {


    val timer = Timer()
    val timerTask = GetUbikeDataTimerTask()

    override fun onCreate() {
        super.onCreate()
        Timber.tag("SERVICE").i("SERVICE ONCREATE")
        timer.schedule(timerTask, 0, 30000)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (timer != null){
            timer.cancel()
            timer.purge()
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    inner class GetUbikeDataTimerTask : TimerTask(){
        override fun run() {
            val data = ubikeApiService.getData().body()
            Timber.tag("SERVICE").i("GET DATA")
        }
    }
}