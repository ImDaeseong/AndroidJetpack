package com.daeseong.box_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Test2()
                }
            }
        }
    }
}

@Composable
fun Test2() {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxWidth().background(Color.Yellow))
    {
        Text(text = "text1", Modifier.align(Alignment.TopCenter))
        Text(text = "text2", Modifier.align(Alignment.Center))
        
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(10.dp),
            onClick = {
                Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
            },backgroundColor = Color.Yellow, contentColor = Color.White)
        {
            Image( painter = painterResource(id = R.drawable.play),null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Box_testTheme {
        Test2()
    }
}