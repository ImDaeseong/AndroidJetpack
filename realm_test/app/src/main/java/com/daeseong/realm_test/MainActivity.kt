package com.daeseong.realm_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.realm_test.ui.theme.Realm_testTheme
import com.opencsv.CSVReader
import io.realm.RealmResults
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.simpleName

    private lateinit var dbHelperLotto: DbHelperLotto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dbHelperLotto = DbHelperLotto()
        //val realm = MyApplicaton.getInstance().getRealm()


        //전체 데이터 삭제
        //deleteLottoAll()

        //csv 파일에서 데이터를 가져와서 입력
        //readCSVtoAdd()

        //전체 데이터 조회
        //readLotto1()

        //개별 데이터 조회
        //readLotto2()

        //데이터 삭제
        //deleteLotto()

        //한개 데이터 입력
        //addLotto()

        setContent {

            Column(modifier = Modifier.fillMaxSize()) {

                TopAppBar( title = { Text(text = "Lotto", color = Color.Red) }, backgroundColor = Color.LightGray)

                val realmResults: RealmResults<Lotto>? = dbHelperLotto.getLotto()
                realm_test1(realmResults)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelperLotto.closeRealm()
    }

    private fun readCSVtoAdd() {
        try {
            val csvReader = CSVReader(InputStreamReader(resources.assets.open("lotto.csv"), "UTF-8"))
            val dbHelperRealm = dbHelperLotto.getRealm()

            dbHelperRealm.beginTransaction()

            var sline: Array<String>?
            while (csvReader.readNext().also { sline = it } != null) {
                val nextId = dbHelperRealm.where(Lotto::class.java).max("_rIndex")?.toInt() ?: 0

                val lotto = dbHelperRealm.createObject(Lotto::class.java, nextId + 1)
                lotto.apply {
                    Date = sline!![1]
                    Part1 = sline!![2].toInt()
                    Part2 = sline!![3].toInt()
                    Part3 = sline!![4].toInt()
                    Part4 = sline!![5].toInt()
                    Part5 = sline!![6].toInt()
                    Part6 = sline!![7].toInt()
                    Bonus = sline!![8].toInt()
                }
            }
            dbHelperRealm.commitTransaction()

        } catch (ex: FileNotFoundException) {
            ex.printStackTrace()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun readLotto1() {
        val realmResults: RealmResults<Lotto>? = dbHelperLotto.getLotto()
        if (realmResults != null) {
            for (lotto in realmResults) {
                val logMessage = "${lotto._rIndex}회차 "  +
                        "${lotto.Date} " +
                        "${lotto.Part1} " +
                        "${lotto.Part2} " +
                        "${lotto.Part3} " +
                        "${lotto.Part4} " +
                        "${lotto.Part5} " +
                        "${lotto.Part6} " +
                        "${lotto.Bonus}"
                Log.e(TAG, logMessage)
            }
        }
    }

    private fun readLotto2() {
        val lotto = dbHelperLotto.getData(1)
        if (lotto != null) {
            val logMessage = "${lotto._rIndex}회차 "  +
                    "${lotto.Date} " +
                    "${lotto.Part1} " +
                    "${lotto.Part2} " +
                    "${lotto.Part3} " +
                    "${lotto.Part4} " +
                    "${lotto.Part5} " +
                    "${lotto.Part6} " +
                    "${lotto.Bonus}"
            Log.e(TAG, logMessage)
        }
    }

    private fun deleteLotto() {
        val bfind = dbHelperLotto.isExistData(1)
        if (bfind) {
            dbHelperLotto.deleteLotto(1)
        }
    }

    private fun deleteLottoAll() {
        val nTotalcount = dbHelperLotto.getLottoRowCount()
        Log.e(TAG, "nTotal count: $nTotalcount")
        dbHelperLotto.deleteLottoAll()
    }

    private fun addLotto() {
        dbHelperLotto.addLotto(1, "2022.03.25", 1, 1, 1, 1, 1, 1, 64)
    }
}

@Composable
fun LottoTable(realmResults: RealmResults<Lotto>?) {

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp) ) {

        //header
        item {
            TableHeaderRow()
        }

        //contents
        items(items = realmResults ?: emptyList()) { lotto ->
            TableRow(lotto = lotto)
        }
    }
}

@Composable
fun TableHeaderRow() {

    Surface(shape = RoundedCornerShape(8.dp), modifier = Modifier) {

        Row(modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                text = "회차",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "날짜",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            for (i in 1..6) {
                Text(
                    text = "번호$i",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.background(Color.Transparent),
                    overflow = TextOverflow.Clip
                )
            }
            Text(
                text = "보너스",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                overflow = TextOverflow.Clip
            )
        }

    }
}

@Composable
fun TableRow(lotto: Lotto?) {

    if (lotto != null) {

        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "${lotto._rIndex}", style = TextStyle(color = Color.Red, fontSize = 16.sp), modifier = Modifier.weight(1f))
            Text(text = lotto.Date.toString(), fontSize = 16.sp, overflow = TextOverflow.Clip)
            Text(text = "${lotto.Part1}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Part2}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Part3}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Part4}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Part5}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Part6}", fontSize = 16.sp, modifier = Modifier.weight(1f))
            Text(text = "${lotto.Bonus}", fontSize = 16.sp, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun realm_test1(realmResults: RealmResults<Lotto>?) {
    LottoTable(realmResults = realmResults)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val dbHelperLotto = DbHelperLotto()
    val realmResults: RealmResults<Lotto>? = dbHelperLotto.getLotto()

    Realm_testTheme {
        realm_test1(realmResults)
    }
}