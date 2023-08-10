package com.daeseong.dropdownmenu_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.dropdownmenu_test.ui.theme.DropdownMenu_testTheme

class DropdownMenu1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropdownMenu_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
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
fun Test1()  {

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopEnd)) {

        IconButton(onClick = { expanded = true })
        {
            Icon(imageVector = Icons.Filled.Menu,null)
        }
        
        DropdownMenu(modifier = Modifier.wrapContentSize(),
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
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    DropdownMenu_testTheme {
        Test1()
    }
}