package com.daeseong.listview_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.listview_test.ui.theme.ListView_testTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListView1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListView_testTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    ListView1_test()
                }
            }
        }
    }
}

@Composable
fun ListView1_test() {

    val mapApi = MapApi

    var itemList by remember { mutableStateOf(emptyList<ItemData>()) }

    val updatedList = mutableListOf<ItemData>()

    Column(modifier = Modifier.fillMaxSize())
    {
        Box(modifier = Modifier.fillMaxWidth().height(600.dp).padding(10.dp).border(1.dp, Color.Gray, shape = RectangleShape))
        {
            LazyColumn(modifier = Modifier.fillMaxSize())
            {
                items(itemList) { item ->

                    Column(modifier = Modifier.fillMaxSize().padding(start = 10.dp, top = 10.dp, end = 10.dp))
                    {
                        Text(text = item.locName)
                    }
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Button(
                onClick = {
                    val item = mapApi.getItem("서울")
                    if (item != null) {
                        itemList = item
                    }
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp))
            {
                Text(text = "button1")
            }

            Button(
                onClick = {
                    val item = mapApi.getItem("부산")
                    if (item != null) {
                        itemList = item
                    }
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp))
            {
                Text(text = "button2")
            }

            Button(
                onClick = {
                    val item = mapApi.getItem("대구")
                    if (item != null) {
                        itemList = item
                    }
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp))
            {
                Text(text = "button3")
            }

            Button(
                onClick = {
                    val map = mapApi.getMap()
                    CoroutineScope(Dispatchers.IO).launch {

                        for (key in map.keys) {
                            val list = map[key]
                            if (list != null) {
                                updatedList.addAll(list)
                            }
                        }

                        withContext(Dispatchers.Main) {
                            itemList = updatedList
                        }
                    }
                },
                modifier = Modifier.weight(1f))
            {
                Text(text = "button4")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ListView_testTheme {
        ListView1_test()
    }
}