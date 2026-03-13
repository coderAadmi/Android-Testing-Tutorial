package com.tc.testingtutorial

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.remote.player.view.RemoteComposePlayer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@SuppressLint("RestrictedApiAndroidX", "RestrictedApi")
@Composable
fun RemoteScreen(modifier: Modifier, ba : ByteArray){
    val context = LocalContext.current
    RemoteComposePlayer(context).apply {
         setDocument(ba)
        addIdActionListener { id, metadata ->
            Log.d("RX_MP", metadata)
        }
    }
}