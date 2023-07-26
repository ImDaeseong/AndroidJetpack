package com.daeseong.topappbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Test3()
                    }
                }
            }
        }
    }
}


@Composable
fun TopAppBarUI1() {

    TopAppBar(
        title = {
            Text("TopAppBar")
        },
        backgroundColor = Color.Gray,
        contentColor = Color.White
    )
}


@Composable
fun TopAppBarUI2() {

    TopAppBar(
        title = {

            Row() {
                Text("TopAppBar1 ", color = Color.Red)
                Text("TopAppBar2 ", color = Color.Green)
                Text("TopAppBar3 ", color = Color.Yellow)
            }
        },
        backgroundColor = Color.Gray,
        contentColor = Color.White
    )
}

@Composable
fun Test3() {

    TopAppBarUI1()
    TopAppBarUI2()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    TopAppBar_testTheme {
        Test3()
    }
}