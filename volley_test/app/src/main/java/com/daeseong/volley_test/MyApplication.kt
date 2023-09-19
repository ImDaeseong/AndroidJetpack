package com.daeseong.volley_test

import android.app.Application
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MyApplication : Application() {

    companion object {
        private lateinit var instance: MyApplication

        fun getInstance(): MyApplication {
            return instance
        }

        private lateinit var requestQueue: RequestQueue

        fun getRequestQueue(): RequestQueue {
            return requestQueue
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        requestQueue = Volley.newRequestQueue(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}

@Composable
fun MyApplicationInstance(): MyApplication {
    val context = LocalContext.current
    return remember(context) {
        context.applicationContext as MyApplication
    }
}