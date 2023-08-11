package com.daeseong.lazyverticalgrid_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazyverticalgrid_test.ui.theme.LazyVerticalGrid_testTheme

class LazyVerticalGrid1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun gridItem(item : String) {

    //Surface Composable 배경색/배경 테두리 등을 설정
    Surface(modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp)
    {
        Text(text = item, modifier = Modifier.padding(10.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Test1() {

    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7")

    LazyVerticalGrid(modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(all = 10.dp))
    {
        items(items.size) { index ->
            gridItem(item = items[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LazyVerticalGrid_testTheme {
        Test1()
    }
}