package com.daeseong.progresscircular_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.progresscircular_test.ui.theme.ProgressCircular_testTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
            {
                Buttons()
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
                val intent = Intent(context, ProgressBar1Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "Button1")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ProgressBar2Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "Button2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProgressCircular_testTheme {
        Buttons()
    }
}