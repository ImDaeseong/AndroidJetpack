package com.daeseong.column_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.column_test.ui.theme.Column_testTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class Column1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column_testTheme {
                Test1()
            }
        }
    }
}

@Composable
fun Test1() {

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth() //전체 넓이
            .height(100.dp) //높이
            .padding(all = 10.dp) //전체 마진 설정
            .background(color = Color.Gray) //배경색
    ) {

        Text(
            modifier = Modifier
                .clickable {
                    Toast.makeText(context, "Text", Toast.LENGTH_SHORT).show()
                }
                .background(color = Color.Gray)
                .fillMaxWidth()
                .padding(start = 10.dp)
                .padding(end = 10.dp),
            text = "text line 1\ntext line 2",
            maxLines = 2,
            fontSize = 28.sp, // 또는 15.dp.toSp()
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Column_testTheme {
       Test1()
    }
}