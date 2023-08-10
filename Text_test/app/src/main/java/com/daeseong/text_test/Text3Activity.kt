package com.daeseong.text_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.text_test.ui.theme.Text_testTheme

class Text3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@Composable
fun Test3() {

    var expanded by remember { mutableStateOf(false) }
    var value by remember { mutableStateOf(getInputStr("메뉴")) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text(
            modifier = Modifier.clickable { expanded = true },
            text = value,
            style = MaterialTheme.typography.h2)

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false }) {

            for(n in 0 until 2) {

                DropdownMenuItem(onClick = {
                    expanded = false
                    value = getInputStr("메뉴${n.toString()}")
                }) {
                    Text("메뉴${n.toString()}")
                }
            }
        }
    }
}

fun getInputStr(input: String): String {
    var result : String = input
    return "$result"
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Text_testTheme {
        Test3()
    }
}