package com.daeseong.bottomappbar_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.bottomappbar_test.ui.theme.BottomAppBar_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
        modifier = Modifier.fillMaxSize(), //전체 영역
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Button (
            onClick = {
                val intent = Intent(context, BottomAppBar1Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button1")
        }

        Button (
            onClick = {
                val intent = Intent(context, BottomAppBar2Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button2")
        }

        Button (
            onClick = {
                val intent = Intent(context, BottomAppBar1Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button3")
        }

        Button (
            onClick = {
                val intent = Intent(context, BottomAppBar1Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button4")
        }

        Button (
            onClick = {
                val intent = Intent(context, BottomAppBar1Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button5")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomAppBar_testTheme {
        Buttons()
    }
}