package com.daeseong.gameinfo_test

import android.content.Context
import android.content.pm.ApplicationInfo
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap

class GameInfo {
    companion object {

        private val TAG = GameInfo::class.java.simpleName

        private val GAME_PACKAGE_NAMES = arrayOf(
            "com.nexon.overhit",  // 오버히트
            "com.netmarble.tera" // 테라M
        )

        fun getGameApp(context: Context): List<GameItem> {

            val gameList = mutableListOf<GameItem>()

            val packages = context.packageManager.getInstalledPackages(0)
            for (info in packages) {
                val appName = info.applicationInfo.loadLabel(context.packageManager).toString()
                val packageName = info.packageName
                val versionName = info.versionName
                val versionCode = info.versionCode
                val gameIcon = info.applicationInfo.loadIcon(context.packageManager).toBitmap().asImageBitmap()

                //일반 앱 정보만 수집
                if (info.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {

                    if (isGamePackageName(packageName)) {
                        val item = GameItem(appName, packageName, versionName, versionCode, gameIcon)
                        gameList.add(item)
                    }
                }
            }
            return gameList
        }

        fun getApkPath(context: Context, packageName: String): String? {
            var sourceDir: String? = null
            try {
                sourceDir = context.packageManager.getApplicationInfo(packageName, 0).sourceDir
            } catch (e: Exception) {
                // Handle exception
            }
            return sourceDir
        }

        private fun isGamePackageName(packageName: String): Boolean {
            return GAME_PACKAGE_NAMES.any { packageName.startsWith(it) }
        }
    }

    data class GameItem(
        val appName: String,
        val packageName: String,
        val versionName: String,
        val versionCode: Int,
        val gameIcon: ImageBitmap?
    )
}
