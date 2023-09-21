package com.daeseong.listview_test

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel

data class Item1Data(
    val locName: String,
    val latitude: Double,
    val longitude: Double
)

class MapApiModel : ViewModel() {

    private val list = mutableListOf<Item1Data>()

    fun addItem(locName: String, latitude: Double, longitude: Double) {

        // 중복 체크
        if (!IsExist(locName)) {
            val item = Item1Data(locName, latitude, longitude)
            list.add(item)
        }
    }

    private fun IsExist(locName: String): Boolean {
        return list.any { it.locName == locName }
    }

    fun getList(): List<Item1Data> {
        return list
    }
}