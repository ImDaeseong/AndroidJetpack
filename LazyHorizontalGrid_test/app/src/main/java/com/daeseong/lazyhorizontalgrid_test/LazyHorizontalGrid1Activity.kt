package com.daeseong.lazyhorizontalgrid_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazyhorizontalgrid_test.ui.theme.LazyHorizontalGrid_testTheme

class LazyHorizontalGrid1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9")

    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxSize()
            .height(50.dp),
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(all = 10.dp))
    {
        items(items.size) { index ->
            val item = items[index]
            Text(modifier = Modifier.background(Color.Gray)
                .wrapContentSize(Alignment.Center),
                text = "입력값: $item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LazyHorizontalGrid_testTheme {
        Test1()
    }
}