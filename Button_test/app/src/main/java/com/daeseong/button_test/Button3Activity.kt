package com.daeseong.button_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

class Button3Activity : ComponentActivity() {
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
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test3()
                    }
                }
            }
        }
    }
}

@Composable
fun Test3() {

    val context = LocalContext.current

    OutlinedButton(
        shape = RoundedCornerShape(size = 8.dp),
        border = BorderStroke(width = 1.dp, color = Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue),
        enabled = true,
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        })
    {
        Image(painter = painterResource(id = R.drawable.play), contentDescription = "play" )
    }

    OutlinedButton(       
        modifier = Modifier.wrapContentSize(),
        onClick = {
            Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
        })
    {
        Text(text = "OutlinedButton")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Button_testTheme {
        Test3()
    }
}