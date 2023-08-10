package com.daeseong.column_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.column_test.ui.theme.Column_testTheme

class Column2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column_testTheme {
                Test2()
            }
        }
    }
}

@Composable
fun Test2() {

    Column( modifier = Modifier.background(color = Color.Gray) )
    {
        Text(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth(),
            text = "text",
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Button (
            onClick = {
            },
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(end = 10.dp)
                .padding(bottom = 10.dp)
                .fillMaxWidth() //전체 넓이
                .height(30.dp)
                .background(color = Color.Yellow) )
        {
            Text(
                text = "button1",
                textAlign = TextAlign.Center,
                color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Column_testTheme {
        Test2()
    }
}