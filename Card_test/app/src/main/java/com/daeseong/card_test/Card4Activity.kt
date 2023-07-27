package com.daeseong.card_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.card_test.ui.theme.Card_testTheme

class Card4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Test4()
            }
        }
    }
}

@Composable
fun CardBorderUI1() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        backgroundColor = Color.Gray)
    {
        Text(modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = TextStyle(fontSize = 20.sp),
            text = "Card1")
    }
}

@Composable
fun CardBorderUI2() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(10.dp))
    {
        Text(modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = TextStyle(fontSize = 20.sp),
            text = "Card1")
    }
}

@Composable
fun CardBorderUI3() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        backgroundColor = Color.Gray,
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Red)),
        shape = RoundedCornerShape(10.dp))
    {
        Text(modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = TextStyle(fontSize = 20.sp),
            text = "Card1")
    }
}

@Composable
fun CardBorderUI4() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        backgroundColor = Color.Gray,
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Red)),
        shape = RoundedCornerShape(10.dp))
    {

        val spannable1 = buildAnnotatedString {
            append("Card1\n")
            addStyle(style = SpanStyle(color = Color.Red), start = 0, end =length)
        }

        val spannable2 = buildAnnotatedString {
            append("Card2")
            addStyle(style = SpanStyle(color = Color.Blue), start = 0, end = length)
        }

        val spannable = spannable1.plus(spannable2)

        Text(modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = TextStyle(fontSize = 20.sp),
            maxLines = 2,
            text = spannable)
    }
}

@Composable
fun CardBorderUI5() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        backgroundColor = Color.Gray,
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Red)),
        shape = RoundedCornerShape(10.dp))
    {
        Image(modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.a),
            contentDescription = null,
            contentScale = ContentScale.FillBounds)
    }
}

@Composable
fun Test4() {

    CardBorderUI1()
    Divider(color = Color.Gray, modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp))

    CardBorderUI2()
    Divider(color = Color.Gray, modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp))

    CardBorderUI3()
    Divider(color = Color.Gray, modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp))

    CardBorderUI4()
    Divider(color = Color.Gray, modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp))

    CardBorderUI5()
    Divider(color = Color.Gray, modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Card_testTheme {
        Test4()
    }
}