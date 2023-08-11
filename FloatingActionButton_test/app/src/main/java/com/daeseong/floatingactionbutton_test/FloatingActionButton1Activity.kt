package com.daeseong.floatingactionbutton_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.floatingactionbutton_test.ui.theme.FloatingActionButton_testTheme

class FloatingActionButton1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(10.dp)) {
                Test1()
            }
        }
    }
}

@Composable
fun FloatingActionButton1() {

    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        },
        content = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    )
}

@Composable
fun FloatingActionButton2() {

    val context = LocalContext.current

    ExtendedFloatingActionButton(
        onClick = {
            Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
        },
        text = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            Text("click2")
        }
    )
}

@Composable
fun Test1() {

    FloatingActionButton1()

    Spacer(modifier = Modifier.height(10.dp))

    FloatingActionButton2()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FloatingActionButton_testTheme {
        Test1()
    }
}