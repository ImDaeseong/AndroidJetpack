package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box7Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test7()
        }
    }
}

@Composable
fun Test7() {

    var borderColor by remember { mutableStateOf(Color.Gray) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .border(BorderStroke(width = 2.dp, color = borderColor))
            .background(Color.White)
            .clickable {
                borderColor = if (borderColor == Color.Gray) {
                    Color.Red
                } else {
                    Color.Gray
                }
            }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    Box_testTheme {
        Test7()
    }
}