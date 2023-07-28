package com.daeseong.card_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.card_test.ui.theme.Card_testTheme

class Card3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Card_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
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

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), elevation = 10.dp) {

        Column(Modifier.padding(10.dp)) {

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 10.sp))
                    {
                        append("append1")
                    }

                    withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    {
                        append(" append2")
                    }
                }
            )

            Text(
                buildAnnotatedString {
                    append("append1")

                    withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    {
                        append(" append2")
                    }
                }
            )

            Text(
                buildAnnotatedString {
                    append("append1")

                    withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    {
                        append(" append2 ")
                    }

                    append("append3")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Card_testTheme {
        Test3()
    }
}