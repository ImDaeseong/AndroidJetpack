package com.daeseong.card_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.card_test.ui.theme.Card_testTheme

class Card1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Card_testTheme {
               Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
               {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test1()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CardUI1()  {

    val context = LocalContext.current
    
    Card(modifier = Modifier.padding(10.dp)
        .clickable {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
        },
        elevation = 10.dp,
        contentColor = Color.Red,
        backgroundColor = Color.White)
    {
        Text(text = "Card", Modifier.padding(10.dp))
    }
}

@Preview
@Composable
fun CardUI2()  {

    Card(modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        contentColor = Color.Red,
        backgroundColor = Color.White)
    {
        Text(text = "Card", Modifier.padding(20.dp))
    }
}

@Preview
@Composable
fun CardUI3()  {

    Card(modifier = Modifier.padding(10.dp),
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 10.dp,
        contentColor = Color.Red,
        backgroundColor = Color.White)
    {
        Text(text = "Card", Modifier.padding(10.dp))
    }
}

@Preview
@Composable
fun CardUI4()  {

    Card(modifier = Modifier.padding(10.dp),
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 10.dp,
        contentColor = Color.Red,
        backgroundColor = Color.White)
    {
        Column() {

            Text(text = "Card1", Modifier.padding(10.dp))
            Text(text = "Card2", Modifier.padding(10.dp))
        }
    }
}

@Composable
fun Test1()  {
    CardUI1()
    CardUI2()
    CardUI3()
    CardUI4()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Card_testTheme {
        Test1()
    }
}