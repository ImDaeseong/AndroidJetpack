package com.daeseong.topappbar_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBar_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
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

    TopAppBar(modifier = Modifier.height(100.dp),  backgroundColor = Color.Gray)
    {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            IconButton(
                onClick = {
                    Toast.makeText(context, "actions1", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.ArrowForward, null)
            }

            Text(text = "TopAppBar", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Red)

            IconButton(
                onClick = {
                    Toast.makeText(context, "actions2", Toast.LENGTH_SHORT).show()
                })
            {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TopAppBar_testTheme {
        Test2()
    }
}