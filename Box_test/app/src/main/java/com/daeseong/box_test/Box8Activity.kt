package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box8Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test8()
        }
    }
}

@Composable
fun Test8() {

    val bgColor = remember { mutableStateOf(Color.Gray) }

    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        contentAlignment = Alignment.Center) {

        Column(modifier = Modifier
            .width(min(400.dp, maxWidth)),
            horizontalAlignment = Alignment.CenterHorizontally){

            Text( modifier = Modifier
                .fillMaxWidth()
                .background(bgColor.value),
                textAlign = TextAlign.Center,
                text = "#${bgColor.value.toArgb().toUInt().toString(16)}")

            setPicker(bgColor)
        }
    }
}

@Composable
fun setPicker(bgColor : MutableState<Color>) {

    val red = bgColor.value.red
    val green = bgColor.value.green
    val blue = bgColor.value.blue

    Column {
        Slider(value = red,
            onValueChange = {
            bgColor.value = Color(it, green, blue)
        })
        Slider(value = green,
            onValueChange = {
            bgColor.value = Color(red, it, blue)
        })
        Slider(value = blue,
            onValueChange = {
            bgColor.value = Color(red, green, it)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    Box_testTheme {
        Test8()
    }
}