package com.daeseong.progresscircular_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.progresscircular_test.ui.theme.ProgressCircular_testTheme

class ProgressBar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            progressCircular_test2()
        }
    }
}


@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    curPercentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 100.dp,
    strokeWidth: Dp = 8.dp)
{
    Box(contentAlignment = Alignment.Center, modifier = modifier)
    {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(radius * 2f))
        {
            Canvas(modifier = Modifier.size(radius * 2f)) {

                // 배경 라인
                drawArc(
                    color = Color.Gray.copy(alpha = 0.3f),
                    -90f,
                    360f,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )

                // 퍼센트
                drawArc(
                    color = Color.Gray.copy(alpha = 1.0f),
                    -90f,
                    360 * curPercentage,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = (curPercentage * number).toInt().toString() + "%",
                Modifier.background(Color.Transparent),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun progressCircular_test2() {

    var curPercentage by remember { mutableStateOf(0.5f) }
    //val curPercentage: Float = 0.0f
    val number: Int = 100
    val fontSize: TextUnit = 28.sp
    val radius: Dp = 100.dp
    val strokeWidth: Dp = 8.dp

    Column(modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Spacer(modifier = Modifier.height(20.dp))

        CircularProgressBar(modifier = Modifier
            .size(100.dp)
            .align(Alignment.CenterHorizontally), curPercentage, number)

        Slider(
            value = curPercentage,
            onValueChange = {
                curPercentage = it
            },
            valueRange = 0f..1f,
            modifier = Modifier.padding(start = 10.dp, top = 20.dp, end = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProgressCircular_testTheme {
        progressCircular_test2()
    }
}