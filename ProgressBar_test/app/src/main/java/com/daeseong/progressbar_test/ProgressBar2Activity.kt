package com.daeseong.progressbar_test

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.progressbar_test.ui.theme.ProgressBar_testTheme

class ProgressBar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun Test2() {

    val progressState = remember { mutableStateOf(0f) }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White)
    {
        Column(modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            LinearProgressIndicator(modifier = Modifier.height(20.dp),
                backgroundColor = Color.Gray,
                color = Color.Red,
                progress = progressState.value
            )
        }
    }

    DisposableEffect(Unit) {

        val timer = object : CountDownTimer(1000 * 10, 100) {

            override fun onTick(lValue: Long) {
                val totalDuration = 10000L
                val elapsedTime = totalDuration - lValue
                progressState.value = elapsedTime / totalDuration.toFloat()
            }

            override fun onFinish() {
                progressState.value = 1.0f
            }
        }
        timer.start()

        onDispose {
            timer.cancel()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProgressBar_testTheme {
        Test2()
    }
}