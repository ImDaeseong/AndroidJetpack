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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.horizontalpager_test.ui.theme.HorizontalPager_testTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

class HorizontalPager2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Test2() {

    val list = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d
    )

    Box(modifier = Modifier.fillMaxSize())
    {
        val pageCount = list.size
        val start = Int.MAX_VALUE / 2
        val pageState = rememberPagerState(initialPage = start)
        val coroutineState = rememberCoroutineScope()

        DisposableEffect(Unit) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {

                    coroutineState.launch {
                        pageState.animateScrollToPage(pageState.currentPage + 1)
                    }
                }
            }, 3000, 3000)
            onDispose {
                timer.cancel()
            }
        }

        HorizontalPager(modifier = Modifier.height(300.dp).background(Color.LightGray),
            state = pageState,
            count = Int.MAX_VALUE,
            itemSpacing = 10.dp,
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp))
        { index ->

            val page = (index - start).floorMod(pageCount)
            println(page)

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), shape = RoundedCornerShape(10.dp))
            {
                Image(
                    painter = painterResource(id = list[page]),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds)
            }
        }
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other = other) * other
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    HorizontalPager_testTheme {
        Test2()
    }
}