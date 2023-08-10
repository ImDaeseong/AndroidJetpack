package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box_testTheme {
                Test5()
            }
        }
    }
}

@Composable
fun Test5() {

    Column(Modifier.fillMaxSize()) {
        
        Box(modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize()
            .weight(1f)) {

            Text(text = "text1", Modifier.align(Alignment.Center))
        }

        Box(modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
            .weight(1f)) {

            Text(text = "text2", Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Box_testTheme {
        Test5()
    }
}