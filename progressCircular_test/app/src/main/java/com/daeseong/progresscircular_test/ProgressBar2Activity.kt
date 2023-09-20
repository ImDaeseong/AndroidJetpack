package com.daeseong.progresscircular_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
fun progressCircular_test2() {

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(Color.Gray) )
    {
        //CircularProgressBar(percentage = 1.0f, number = 100)

        val radius: Dp = 100.dp
        val strokeWidth: Dp =8.dp
        val curPercentage : Float = 1.0f
        val fontSize: TextUnit = 28.sp
        val number:Int = 100

        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f).background(Color.Green))
        {
            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = Color.Red,
                    -90f,
                    360 * curPercentage,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = (curPercentage * number).toInt().toString() + "%",
                Modifier.background(Color.Blue),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProgressCircular_testTheme {
        progressCircular_test2()
    }
}