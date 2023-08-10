package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test1()
                    }
                }
            }
        }
    }
}

@Composable
fun Test1() {

    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .size(width = 300.dp, height = 100.dp)) {

        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter", Modifier.align(Alignment.TopCenter))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))

        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))

        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter", Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Box_testTheme {
        Test1()
    }
}