package com.daeseong.button_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.button_test.ui.theme.Button_testTheme

class Button4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
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
fun Test4() {

    val context = LocalContext.current

    TextButton(
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        }
    )
    {
        Text(text = "TextButton1")
    }

    TextButton(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Gray
        ),
        border = BorderStroke(width = 1.dp, color = Color.Red),
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        }
    )
    {
        Text(text = "TextButton2")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Button_testTheme {
        Test4()
    }
}