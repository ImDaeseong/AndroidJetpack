package com.daeseong.column_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize(), //전체 영역
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button (
            onClick = {
                val intent = Intent(context, Column1Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button1")
        }

        Button (
            onClick = {
                val intent = Intent(context, Column2Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button2")
        }

        Button (
            onClick = {
                val intent = Intent(context, Column3Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button3")
        }

        Button (
            onClick = {
                val intent = Intent(context, Column4Activity::class.java)
                context.startActivity(intent)
            } ,
            modifier = Modifier.padding(10.dp) )
        {
            Text(text = "button4")
        }

        Button (
            onClick = {
                val intent = Intent(context, Column5Activity::class.java)
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
    Buttons()
}
