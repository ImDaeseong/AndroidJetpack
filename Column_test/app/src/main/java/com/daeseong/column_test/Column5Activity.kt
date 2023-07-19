package com.daeseong.column_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Column5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test5()
        }
    }
}

@Composable
fun Test5() {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(0.dp)
            .background(color = Color.Gray)
            .fillMaxWidth()
            .verticalScroll(scrollState) )
    {

        Column(modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Red))
            .padding(10.dp)
            .fillMaxWidth())
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Column1"
            )
        }

        Column(modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Red))
            .padding(10.dp)
            .fillMaxWidth())
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Column2"
            )
        }

        Column(modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Red))
            .padding(10.dp)
            .fillMaxWidth())
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Column3"
            )
        }

        Column(modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Red))
            .padding(10.dp)
            .fillMaxWidth())
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Column4"
            )
        }

        Column(modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Red))
            .padding(10.dp)
            .fillMaxWidth())
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Column5"
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Test5()
}