package com.daeseong.realm_test

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Lotto : RealmObject() {
    @PrimaryKey
    var _rIndex: Int = 0
    var Date: String? = null
    var Part1: Int = 0
    var Part2: Int = 0
    var Part3: Int = 0
    var Part4: Int = 0
    var Part5: Int = 0
    var Part6: Int = 0
    var Bonus: Int = 0
}