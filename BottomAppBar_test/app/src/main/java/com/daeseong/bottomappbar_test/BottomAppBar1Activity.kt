package com.daeseong.bottomappbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.bottomappbar_test.ui.theme.BottomAppBar_testTheme

class BottomAppBar1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
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

    BottomAppBar(backgroundColor = Color.Gray) {

        IconButton(onClick = {  }) {

            Icon(Icons.Filled.Menu, "")
        }

        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(onClick = {  }) {

            Icon(Icons.Filled.Home, "")
        }

        IconButton(onClick = {  }) {

            Icon(Icons.Filled.Email, "")
        }

        IconButton(onClick = {  }) {

            Icon(Icons.Filled.MoreVert, "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    BottomAppBar_testTheme {
        Test1()
    }
}