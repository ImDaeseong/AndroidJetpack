package com.daeseong.button_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.button_test.ui.theme.Button_testTheme

class Button1Activity : ComponentActivity() {
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
fun Test1() {

    val context = LocalContext.current

    Button(
        modifier = Modifier
            .width(width = 200.dp)
            .height(height = 50.dp),
        enabled = true,
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(size = 8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.LightGray
        ),
        border = BorderStroke(width = 1.dp, color = Color.Red))
    {
        Text(text = "Button1")
        Spacer(modifier = Modifier.size(50.dp))
        Text(text = "Click")
    }

    Button(
        modifier = Modifier
            .padding(top = 20.dp)
            .width(width = 200.dp)
            .height(height = 50.dp),
        enabled = false,
        onClick = {
            Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(size = 8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.LightGray
        ),
        border = BorderStroke(width = 1.dp, color = Color.Red))
    {
        Text(text = "Button2")
        Spacer(modifier = Modifier.size(50.dp))
        Text(text = "Click")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Button_testTheme {
        Test1()
    }
}