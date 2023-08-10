package com.daeseong.row_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.row_test.ui.theme.Row_testTheme

class Row3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Test3()
                }
            }
        }
    }
}

@Composable
fun Test3() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween)
    {
        val scrollState = rememberScrollState()

        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Gray)
                .fillMaxWidth()
                .height(40.dp)
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Top Row1"
            )

            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Top Row2"
            )

            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Top Row3"
            )

            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Top Row4"
            )

            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .wrapContentSize(Alignment.Center),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "Top Row5"
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
                .fillMaxWidth()
                .height(50.dp)
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "text2")
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Blue)
                .fillMaxWidth()
                .height(40.dp)
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "text3")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Row_testTheme {
        Test3()
    }
}