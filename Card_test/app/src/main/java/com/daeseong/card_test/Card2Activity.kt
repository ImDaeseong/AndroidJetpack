package com.daeseong.card_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.card_test.ui.theme.Card_testTheme

class Card2Activity : ComponentActivity() {
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
                        Test2()
                    }
                }
            }
        }
    }
}

@Composable
fun CardUI5()  {

    Card(modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    )
    {
        Box(modifier = Modifier.height(200.dp))
        {
            Image(painter = painterResource(id = R.drawable.a), contentDescription = null, contentScale = ContentScale.Fit)

        }
    }
}

@Composable
fun CardUI6()  {

    Card(modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    )
    {
        Box(modifier = Modifier.height(200.dp)) {

            Image(modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                contentScale = ContentScale.FillBounds)

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0.25f
                    )
                )
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(text = "test", color = Color.White)
            }
        }
    }
}

@Composable
fun Test2()  {

    CardUI5()
    CardUI6()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Card_testTheme {
        Test2()
    }
}