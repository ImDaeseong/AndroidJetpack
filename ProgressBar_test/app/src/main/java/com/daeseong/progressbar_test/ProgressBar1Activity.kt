package com.daeseong.progressbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.progressbar_test.ui.theme.ProgressBar_testTheme

class ProgressBar1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun ProgressBarUI1() {

    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        LinearProgressIndicator(modifier = Modifier
            .padding(bottom = 10.dp)
            .width(100.dp)
            .height(20.dp),
            backgroundColor = Color.Gray,
            color = Color.Red,
            progress = 1.0f
        )

        CircularProgressIndicator(modifier = Modifier
            .padding(top = 10.dp)
            .size(100.dp),
            strokeWidth = 20.dp,
            color = Color.Green,
            progress = 1.0f
        )
    }
}

@Composable
fun Test1() {
    ProgressBarUI1()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ProgressBar_testTheme {
        Test1()
    }
}