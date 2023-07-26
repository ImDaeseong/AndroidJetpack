package com.daeseong.bottomappbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.bottomappbar_test.ui.theme.BottomAppBar_testTheme

class BottomAppBar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test2()
                    }
                }
            }
        }
    }
}

@Composable
fun Test2() {

    BottomAppBar(modifier = Modifier
        .height(60.dp)
        .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)),
        cutoutShape = CircleShape,
        backgroundColor = Color.Gray) {

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
fun DefaultPreview3() {
    BottomAppBar_testTheme {
        Test2()
    }
}