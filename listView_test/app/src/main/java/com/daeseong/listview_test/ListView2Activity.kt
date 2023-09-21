package com.daeseong.listview_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daeseong.listview_test.ui.theme.ListView_testTheme

class ListView2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        setContent {
            ListView2_test(viewModel)
        }
    }
}

@Composable
fun ListView2_test(viewModel: ListViewModel) {

    val list by remember { viewModel.list }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "ListView2") },
                backgroundColor = Color.Blue)
        })
    {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp) )
        {
            items(list) { item ->
                ItemCard(item)
            }
        }
    }
}

@Composable
fun ItemCard(item: Item1Data) {

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)
            .clickable {  },
        elevation = 4.dp)
    {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Column {
                Text(text = item.locName, style = MaterialTheme.typography.h6)
                Text(text = "Loc: ${item.latitude} (${item.longitude})")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ListView_testTheme {
        val viewModel = viewModel<ListViewModel>()
        ListView2_test(viewModel)
    }
}

class ListViewModel : ViewModel() {

    val list: MutableState<List<Item1Data>> = mutableStateOf(emptyList())

    init {

        val model = MapApiModel()
        model.addItem("강남 역삼 삼성 논현", 0.0, 0.0)
        model.addItem("서초 방배 반포", 0.0, 0.0)
        model.addItem("신길 영등포 여의도 문래", 0.0, 0.0)
        model.addItem("구로 금천 신도림", 0.0, 0.0)
        model.addItem("강서 화곡 까치산 목동", 0.0, 0.0)
        model.addItem("천호 길동 둔촌", 0.0, 0.0)
        model.addItem("서울대 신림 봉천", 0.0, 0.0)
        model.addItem("대방 노량진 사당", 0.0, 0.0)
        model.addItem("종로 대학로", 0.0, 0.0)
        model.addItem("용산 중구 명동 이태원", 0.0, 0.0)
        model.addItem("성북 도봉 노원", 0.0, 0.0)
        model.addItem("강북 수유 미아", 0.0, 0.0)
        model.addItem("왕십리 성수", 0.0, 0.0)
        model.addItem("건대 광진", 0.0, 0.0)
        model.addItem("동대문 장안 청량리", 0.0, 0.0)
        model.addItem("중랑 상봉 면목 태릉", 0.0, 0.0)
        model.addItem("신촌 홍대 서대문 마포", 0.0, 0.0)
        model.addItem("은평 연신내 불광", 0.0, 0.0)
        model.addItem("잠실 신천 송파 석촌", 0.0, 0.0)

        val items = model.getList()
        list.value = items
    }
}