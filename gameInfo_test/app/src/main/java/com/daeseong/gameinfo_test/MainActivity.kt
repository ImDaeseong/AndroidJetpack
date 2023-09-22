package com.daeseong.gameinfo_test

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
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

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameInfo_testTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
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

                Handler(Looper.getMainLooper()).postDelayed({
                    val gameItems = GameInfo.getGameApp(context)
                    for (element in gameItems) {
                        Toast.makeText(context, element.packageName, Toast.LENGTH_SHORT).show()
                    }
                }, 100)

            })
        {
            Text(text = "button1")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {

                val intent = Intent(context, GameCheckService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(intent)
                } else {
                    context.startService(intent)
                }
            })
        {
            Text(text = "button2")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {

                val intent = Intent(context, GameCheckService::class.java)
                context.stopService(intent)
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