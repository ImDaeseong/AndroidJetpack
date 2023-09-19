package com.daeseong.volley_test

import android.content.Intent
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
import com.daeseong.volley_test.ui.theme.Volley_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Volley_testTheme {
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
                val intent = Intent(context, Volley1Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "StringRequest")
        }
        
        Button(modifier = Modifier.fillMaxWidth(), 
            onClick = {
                val intent = Intent(context, Volley2Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "ImageRequest")
        }
        
        Button(modifier = Modifier.fillMaxWidth(), 
            onClick = {
                val intent = Intent(context, Volley3Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "JsonObjectRequest")
        }
        
        Button(modifier = Modifier.fillMaxWidth(), 
            onClick = {
                val intent = Intent(context, Volley4Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "GetRequestData getInstance")            
        }
        
        Button(modifier = Modifier.fillMaxWidth(), 
            onClick = {
                val intent = Intent(context, Volley5Activity::class.java)
                context.startActivity(intent)
            })
        {
            Text(text = "MyApplication getInstance")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Volley_testTheme {
        Buttons()
    }
}