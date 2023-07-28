package com.daeseong.lazycolumn_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.lazycolumn_test.ui.theme.LazyColumn_testTheme

class Column2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Test2()
                }
            }
        }
    }
}

@Composable
fun itemUI(values : Int){

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .border(width = 1.dp, color = Color.Gray)
        .height(100.dp))
    {
        Box(contentAlignment = Alignment.Center){
            Text(text = "items: $values")
        }
    }
}

@Composable
fun itemUI1(values : Int){

    Card(modifier = Modifier
        .padding(10.dp),
        elevation = 5.dp)
    {
        Column() {
            
            Image(modifier = Modifier
                .height(90.dp)
                .fillMaxWidth(),
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                contentScale = ContentScale.Fit)

            Text(modifier = Modifier.fillMaxWidth(),
                text = "items: $values",
                textAlign = TextAlign.Center,
                color = Color.Red)
        }
    }
}

@Composable
fun itemUI2(values : Int){

    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Image(modifier = Modifier
            .padding(start = 10.dp)
            .size(50.dp)
            .fillMaxWidth(),
            painter = painterResource(id = R.drawable.play),
            contentDescription = null,
            contentScale = ContentScale.Fit)

        Spacer(Modifier.width(10.dp))

        Text(modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth(),
            text = "items: $values",
            textAlign = TextAlign.Start,
            color = Color.Red)
    }
}

@Composable
fun itemUI3(values : Int){

    Row( modifier = Modifier
        .padding(start = 10.dp)
        .padding(end = 10.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(modifier = Modifier.wrapContentSize(Alignment.Center),
            text = "items: $values",
            textAlign = TextAlign.Start,
            color = Color.Red)

        Image(modifier = Modifier
            .padding(start = 10.dp)
            .size(50.dp),
            painter = painterResource(id = R.drawable.play),
            contentDescription = null,
            contentScale = ContentScale.Fit)
    }
}

@Composable
fun Test2() {

    val scrollState = rememberLazyListState()

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp),
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {

        items(2) {
            itemUI(values = it)
        }


        item() {
            itemUI1(2)
        }

        item() {
            itemUI2(3)
        }

        item() {
            itemUI3(4)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LazyColumn_testTheme {
        Test2()
    }
}