package com.daeseong.lazyverticalgrid_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazyverticalgrid_test.ui.theme.LazyVerticalGrid_testTheme

class LazyVerticalGrid2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Test2() {

    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7")

    LazyVerticalGrid(modifier = Modifier.fillMaxSize()
        .padding(10.dp).background(Color.Gray),
        cells = GridCells.Fixed(3))
    {
        items(items.size) { index ->
            val item = items[index]
            //println(item)
            Text(text = "입력값: $item", Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LazyVerticalGrid_testTheme {
        Test2()
    }
}