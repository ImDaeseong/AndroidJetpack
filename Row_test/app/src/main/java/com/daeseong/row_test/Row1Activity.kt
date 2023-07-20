package com.daeseong.row_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

class Row1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray))
    {
        Row(
            modifier = Modifier
                .background(Color.White)
                .border(BorderStroke(1.dp, Color.Red))
                .height(50.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row1"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row2"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row3"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row4"
            )
        }

        Row(
            modifier = Modifier
                .background(Color.White)
                .border(BorderStroke(1.dp, Color.Red))
                .height(50.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row1"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row2"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row3"
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Row4"
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Test1()
}