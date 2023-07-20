package com.daeseong.row_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Row2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun Test2() {

    Column(
        modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White),
            verticalArrangement = Arrangement.Top)
        {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .height(30.dp)
                        .background(Color.LightGray)
                        .padding(0.dp))
                {
                    Text(
                        text = "left",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }

                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .height(30.dp)
                        .background(Color.LightGray)
                        .padding(0.dp))
                {
                    Text(
                        text = "center",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }

                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .height(30.dp)
                        .background(Color.LightGray)
                        .padding(0.dp))
                {
                    Text(
                        text = "right",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }

        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Gray),
            verticalArrangement = Arrangement.Bottom)
        {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .height(30.dp)
                        .background(Color.LightGray)
                        .padding(0.dp))
                {
                    Text(
                        text = "left",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }

                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .height(30.dp)
                        .background(Color.LightGray)
                        .padding(0.dp))
                {
                    Text(
                        text = "right",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Test2()
}