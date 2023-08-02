package com.daeseong.horizontalpager_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.horizontalpager_test.ui.theme.HorizontalPager_testTheme
import com.google.accompanist.pager.*

class HorizontalPager1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Test1() {

    val pageState = rememberPagerState()

    val list = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d
    )

    Column(modifier = Modifier.fillMaxSize())
    {
        HorizontalPager(
            count = list.size,
            state = pageState,
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
            modifier = Modifier
                .height(300.dp)
                .background(Color.LightGray)
        ) { index ->
            
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), shape = RoundedCornerShape(10.dp))
            {
                Image(
                    painter = painterResource(id = list[index]),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds)
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        HorizontalPagerIndicator(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(bottom = 10.dp),
            inactiveColor = Color.LightGray,
            activeColor = Color.Red,
            pagerState = pageState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    HorizontalPager_testTheme {
        Test1()
    }
}