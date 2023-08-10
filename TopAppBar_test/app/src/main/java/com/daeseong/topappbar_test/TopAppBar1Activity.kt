package com.daeseong.topappbar_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
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

    val context = LocalContext.current

    TopAppBar(
        elevation = 4.dp,
        title = {
            Text("TopAppBar")
        },
        backgroundColor = Color.Gray,
        navigationIcon = {
            IconButton(
                onClick = {
                Toast.makeText(context, "navigationIcon", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.Favorite, null)
            }
        }, actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "actions1", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.ArrowBack, null)
            }

            IconButton(
                onClick = {
                    Toast.makeText(context, "actions2", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.ArrowForward, null)
            }

            IconButton(
                onClick = {
                    Toast.makeText(context, "actions3", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.AccountBox, null)
            }
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TopAppBar_testTheme {
        Test1()
    }
}