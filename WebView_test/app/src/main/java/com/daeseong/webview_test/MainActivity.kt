package com.daeseong.webview_test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.webview_test.ui.theme.WebView_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Buttons()
        }
    }
}

@Composable
fun ButtonEx(context : Context, intent : Intent, title : String) {

    Button (
        onClick = {
            context.startActivity(intent)
        } ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
    )

    {
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            text = title,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun Buttons()  {

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        ButtonEx(context, Intent(context, WebView1Activity::class.java), "button1")
        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = Color.Gray)

        ButtonEx(context, Intent(context, WebView2Activity::class.java), "button2")
        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = Color.Gray)

        ButtonEx(context, Intent(context, WebView1Activity::class.java), "button3")
        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = Color.Gray)

        ButtonEx(context, Intent(context, WebView1Activity::class.java), "button4")
        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = Color.Gray)

        ButtonEx(context, Intent(context, WebView1Activity::class.java), "button5")
        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WebView_testTheme {
        Buttons()
    }
}