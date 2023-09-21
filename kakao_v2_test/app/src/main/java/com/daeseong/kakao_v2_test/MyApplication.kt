package com.daeseong.kakao_v2_test

import android.app.Application
import com.kakao.sdk.common.KakaoSdk.init

class MyApplication : Application() {

    companion object {
        private lateinit var instance: MyApplication

        fun getInstance(): MyApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        // Kakao Sdk 초기화
        init(this, resources.getString(R.string.kakao_id))
    }
}
