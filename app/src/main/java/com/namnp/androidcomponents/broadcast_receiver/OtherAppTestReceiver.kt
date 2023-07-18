package com.namnp.androidcomponents.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class OtherAppTestReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "TEST_ACTION") {
            println("Receiver broadcast from other apps: TEST_ACTION")
        }
    }
}