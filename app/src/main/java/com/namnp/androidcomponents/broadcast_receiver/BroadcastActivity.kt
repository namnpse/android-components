package com.namnp.androidcomponents.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class BroadcastActivity : ComponentActivity() {

    private val airplaneModeReceiver = AirplaneModeReceiver()
    private val otherAppTestReceiver = OtherAppTestReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerReceiver(
            airplaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )

        registerReceiver(
            otherAppTestReceiver,
            IntentFilter("TEST_ACTION")
        )

        setContent {

        }
    }

    override fun onDestroy() {
        unregisterReceiver(airplaneModeReceiver)
        unregisterReceiver(otherAppTestReceiver)
        super.onDestroy()
    }
}

//NOTE:
//1. Two types of Broadcast:
// - Static: declared in the manifest file, works even if the app is closed: ex: BOOT_COMPLETED
// - Dynamic: works only if the app is active or minimized
//2. most of the broadcast can only be caught by the dynamic receiver
//3. Send broadcast to other apps
// specify ACTION_NAME, data(bundle), package_name (if target to a specific app)
//Ex:
//App A send broadcast with action "TEST_ACTION": (dynamic broadcast)
//    sendBroadcast(
//        Intent("TEST_ACTION")
//    )
//
//App B:
//        registerBroadcastReceiver(
//            "TEST_ACTION"
//        )

