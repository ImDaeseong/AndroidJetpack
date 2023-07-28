package com.daeseong.button_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.button_test.ui.theme.Button_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button_testTheme {

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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button (
            onClick = {
                val intent = Intent(context, Button1Activity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Gray),
            modifier = Modifier.wrapContentSize())
        {
            Text(text = "button1", color = Color.White)
            Text(text = "Click", color = Color.Black)
        }

        Button (
            onClick = {
                val intent = Intent(context, Button2Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.wrapContentSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray, contentColor = Color.Red))
        {
            Text(text = "button2")
            Text(text = "Click")
        }

        Button (
            onClick = {
                val intent = Intent(context, Button3Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.wrapContentSize() )
        {
            
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "play",
                modifier = Modifier.size(40.dp)
            )
            
            Text(text = "button3", Modifier.padding(start = 10.dp))
        }
        
        Spacer(modifier = Modifier.height(10.dp))

        Button (
            onClick = {
                val intent = Intent(context, Button4Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.wrapContentSize() )
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "play",
                    modifier = Modifier.size(40.dp)
                )

                Text(text = "button4", Modifier.padding(top = 10.dp))
            }
        }

        Button (
            onClick = {
                val intent = Intent(context, Button5Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(10.dp))
        {
            Text(text = "button5 Click")
        }

        Button (
            onClick = {
                val intent = Intent(context, Button6Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(10.dp))
        {
            Text(text = "button6 Click")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Button_testTheme {
        Buttons()
    }
}