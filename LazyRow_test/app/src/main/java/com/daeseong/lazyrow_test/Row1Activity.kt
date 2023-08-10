package com.daeseong.lazyrow_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazyrow_test.ui.theme.LazyRow_testTheme

class Row1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Test1()
            }
        }
    }
}

@Composable
fun Test1() {

    LazyRow(
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(bottom = 20.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .fillMaxWidth())
    {
        item {
            Text(text = "start text1", Modifier.padding(10.dp))
        }

        items(count = 50) { values ->
            Text(text = "items: $values", Modifier.padding(10.dp))
        }

        item {
            Text(text = "end text1", Modifier.padding(10.dp))
        }

    }

    Spacer(modifier = Modifier.height(10.dp))

    LazyRow(
        modifier = Modifier
             .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp) )
    {
        item {

            Image(modifier = Modifier.size(100.dp).background(Color.Gray),
                painter = painterResource(id = R.drawable.a),
                contentDescription = null)
        }

        items( 5) {
            Image(modifier = Modifier.size(100.dp).background(Color.Gray),
                painter = painterResource(id = R.drawable.play),
                contentDescription = null)
        }

        item {
            Image(modifier = Modifier.size(100.dp).background(Color.Gray),
                painter = painterResource(id = R.drawable.b),
                contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LazyRow_testTheme {
        Test1()
    }
}