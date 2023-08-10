package com.daeseong.lazycolumn_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazycolumn_test.ui.theme.LazyColumn_testTheme

class Column1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            Column(modifier = Modifier.fillMaxSize()) {
                Test1()
            }
        }
    }
}

@Composable
fun Test1() {

    LazyColumn(
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(bottom = 20.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp) )
            .fillMaxSize())
    {
        item {
            Text(text = "start text1", Modifier.padding(top = 10.dp).padding(start = 10.dp).padding(end = 10.dp))
        }

        items(count = 50) { values ->
            Text(text = "items: $values", Modifier.padding(start = 10.dp).padding(end = 10.dp))
        }

        item {
            Text(text = "end text1", Modifier.padding(bottom = 10.dp).padding(start = 10.dp).padding(end = 10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LazyColumn_testTheme {
        Test1()
    }
}