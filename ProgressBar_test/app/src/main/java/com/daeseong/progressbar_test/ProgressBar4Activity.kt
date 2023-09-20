package com.daeseong.progressbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import com.daeseong.progressbar_test.ui.theme.ProgressBar_testTheme

class ProgressBar4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressBar_testTheme {
                Test4()
            }
        }
    }
}

@Composable
fun Test4() {

    var progress by remember { mutableStateOf(0.5f) }


    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center )
    {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = Color.Red, // 진행 바의 색상 설정
            backgroundColor = Color.Gray // 진행 바의 배경색 설정
        )

        Text(
            text = "${(progress * 100).roundToInt()}%",
            Modifier.align(Alignment.CenterHorizontally),
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Slider(
            value = progress,
            onValueChange = {
                progress = it
            },
            valueRange = 0f..1f,
            steps = 100,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ProgressBar_testTheme {
        Test4()
    }
}