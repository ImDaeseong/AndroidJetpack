package com.daeseong.listview_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.listview_test.ui.theme.ListView_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Buttons()
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
                val intent = Intent(context, ListView1Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button1")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView2Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button2")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView3Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button3")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView4Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button4")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView5Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button5")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView6Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button6")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView7Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button7")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView8Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button8")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView9Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button9")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView10Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button10")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(context, ListView11Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "button511")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListView_testTheme {
        Buttons()
    }
}