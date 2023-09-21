package com.daeseong.gameinfo_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.gameinfo_test.ui.theme.GameInfo_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameInfo_testTheme {
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

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center)
    {
        val context = LocalContext.current

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                //val intent = Intent(context, ListView1Activity::class.java)
                //context.startActivity(intent)
            })
        {
            Text(text = "button1")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                //val intent = Intent(context, ListView2Activity::class.java)
                //context.startActivity(intent)
            })
        {
            Text(text = "button2")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                //val intent = Intent(context, ListView3Activity::class.java)
                //context.startActivity(intent)
            })
        {
            Text(text = "button3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameInfo_testTheme {
        Buttons()
    }
}