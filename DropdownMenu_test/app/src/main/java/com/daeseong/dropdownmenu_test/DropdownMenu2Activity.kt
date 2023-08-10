package com.daeseong.dropdownmenu_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.dropdownmenu_test.ui.theme.DropdownMenu_testTheme

class DropdownMenu2Activity : ComponentActivity() {
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
                        Test2()
                    }
                }
            }
        }
    }
}

@Composable
fun Test2() {

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart))
    {
        IconButton(onClick = { expanded = true })
        {
            Icon(imageVector = Icons.Filled.Menu,"DropdownMenu", tint = Color.Red)
        }

        DropdownMenu(modifier = Modifier
            .background(Color.Blue)
            .clip(RoundedCornerShape(10.dp)),
            expanded = expanded,
            onDismissRequest = { expanded = false })
        {
            DropdownMenuItem(onClick = { expanded = false }) {
                Text(text = "menu1", color = Color.Red)
            }

            DropdownMenuItem(onClick = { expanded = false }) {
                Text(text = "menu2", color = Color.Red)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    DropdownMenu_testTheme {
        Test2()
    }
}