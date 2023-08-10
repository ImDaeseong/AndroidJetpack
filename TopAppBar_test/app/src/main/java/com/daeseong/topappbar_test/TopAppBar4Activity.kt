package com.daeseong.topappbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar4Activity : ComponentActivity() {
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
                        Test4()
                    }
                }
            }
        }
    }
}

@Composable
fun Test4()  {

    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text("TopAppBar")
        },
        navigationIcon = {

        }, actions = {

            IconButton(onClick = { expanded = true })
            {
                Icon(imageVector = Icons.Filled.Menu,null)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false })
            {
                DropdownMenuItem(onClick = { expanded = false }) {
                    Text(text = "menu1")
                }

                DropdownMenuItem(onClick = { expanded = false }) {
                    Text(text = "menu2")
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    TopAppBar_testTheme {
        Test4()
    }
}