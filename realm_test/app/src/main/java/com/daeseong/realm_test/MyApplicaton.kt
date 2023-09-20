package com.daeseong.realm_test

import android.app.Application
import android.content.res.Configuration
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplicaton : Application() {

    private lateinit var realm: Realm
    fun getRealm(): Realm = realm

    companion object {
        private lateinit var instance: MyApplicaton

        fun getInstance(): MyApplicaton {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initRealm()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    private fun initRealm() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true) // UI Thread realm 접근 가능
            .deleteRealmIfMigrationNeeded() // db 변경사항 있을시 저장 데이터 모두 삭제
            .name("Lotto")
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        realm = Realm.getInstance(realmConfiguration)
    }
}