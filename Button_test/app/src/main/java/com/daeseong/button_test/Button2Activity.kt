package com.daeseong.button_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.button_test.ui.theme.Button_testTheme

class Button2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button_testTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test2()
                    }
                }
            }
        }
    }
}

@Composable
fun Test2() {

    val context = LocalContext.current

    IconButton(
        modifier = Modifier.size(50.dp),
        enabled = true,
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        })
    {
        Image(painter = painterResource(id = R.drawable.play), contentDescription = "play" )
    }

    IconButton(
        enabled = true,
        onClick = {
            Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
        })
    {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
    }

    IconButton(
        enabled = true,
        onClick = {
            Toast.makeText(context, "click3", Toast.LENGTH_SHORT).show()
        })
    {
        Icon(Icons.Filled.Email, contentDescription = "Email")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Button_testTheme {
        Test2()
    }
}