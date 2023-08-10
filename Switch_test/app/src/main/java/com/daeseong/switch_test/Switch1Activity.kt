package com.daeseong.switch_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.switch_test.ui.theme.Switch_testTheme

class Switch1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Switch_testTheme {
                 Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                 {
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

    val checked = remember { mutableStateOf(true) }

    Switch(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp)
            .background(Color.Yellow, shape = RoundedCornerShape(16.dp)),
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            uncheckedThumbColor = Color.Gray,
            checkedTrackColor = Color.DarkGray,
            uncheckedTrackColor = Color.Gray,
            checkedTrackAlpha = 1.0f,
            uncheckedTrackAlpha = 1.0f
        ),
        enabled = true,
        checked = checked.value,
        onCheckedChange = {
            checked.value = it}
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Switch_testTheme {
        Test1()
    }
}