package com.daeseong.realm_test

import android.util.Log
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort

class DbHelperLotto {

    private val TAG = DbHelperLotto::class.simpleName

    //이렇게 하면 더이 사아 생성자(init)는 필요하지 않다.
    private val realm: Realm = MyApplicaton.getInstance().getRealm()

    /*
    private val realm: Realm

    //생성자
    init {
        realm = MyApplicaton.getInstance().getRealm()
    }
    */

    fun getLotto(): RealmResults<Lotto>? {
        try {
            return realm.where(Lotto::class.java)
                .sort("_rIndex", Sort.DESCENDING)
                .findAll()
        } catch (ex: Exception) {
            Log.e(TAG, ex.message.toString())
        }
        return null
    }

    fun getRealm(): Realm {
        return realm
    }

    fun closeRealm() {
        realm.close()
    }

    fun addLotto(rIndex: Int, date: String, part1: Int, part2: Int, part3: Int, part4: Int, part5: Int, part6: Int, bonus: Int) {
        realm.executeTransaction { realm ->
            val existingLotto = realm.where(Lotto::class.java).equalTo("_rIndex", rIndex).findFirst()
            if (existingLotto == null) {
                val lotto = realm.createObject(Lotto::class.java, rIndex)
                lotto.Date = date
                lotto.Part1 = part1
                lotto.Part2 = part2
                lotto.Part3 = part3
                lotto.Part4 = part4
                lotto.Part5 = part5
                lotto.Part6 = part6
                lotto.Bonus = bonus
            }
        }
    }

    /*
    fun addLotto(rIndex: Int, date: String, part1: Int, part2: Int, part3: Int, part4: Int, part5: Int, part6: Int, bonus: Int) {
        realm.executeTransaction { realm ->
            val lotto = realm.createObject(Lotto::class.java, rIndex)
            lotto.Date = date
            lotto.Part1 = part1
            lotto.Part2 = part2
            lotto.Part3 = part3
            lotto.Part4 = part4
            lotto.Part5 = part5
            lotto.Part6 = part6
            lotto.Bonus = bonus
        }
    }
    */

    fun isExistData(rIndex: Int): Boolean {
        val lotto = realm.where(Lotto::class.java).equalTo("_rIndex", rIndex).findFirst()
        return lotto != null
    }

    fun getData(rIndex: Int): Lotto? {
        return realm.where(Lotto::class.java).equalTo("_rIndex", rIndex).findFirst()
    }

    fun deleteLotto(rIndex: Int) {
        realm.executeTransaction { realm ->
            val lotto = realm.where(Lotto::class.java).equalTo("_rIndex", rIndex).findFirst()
            lotto?.deleteFromRealm()
        }
    }

    fun getLottoRowCount(): Int {
        return realm.where(Lotto::class.java).count().toInt()
    }

    fun deleteLottoAll() {
        realm.executeTransaction { realm ->
            realm.deleteAll()
        }
    }
}