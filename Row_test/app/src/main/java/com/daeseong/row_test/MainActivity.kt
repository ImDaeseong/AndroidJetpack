package com.daeseong.row_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.row_test.ui.theme.Row_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row_testTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Buttons()
                }
            }
        }
    }
}

@Composable
fun Buttons() {

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button (
            onClick = {
                val intent = Intent(context, Row1Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button1")
        }

        Button (
            onClick = {
                val intent = Intent(context, Row2Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button2")
        }

        Button (
            onClick = {
                val intent = Intent(context, Row3Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button3")
        }

        Button (
            onClick = {
                val intent = Intent(context, Row4Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button4")
        }

        Button (
            onClick = {
                val intent = Intent(context, Row5Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button5")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Row_testTheme {
        Buttons()
    }
}