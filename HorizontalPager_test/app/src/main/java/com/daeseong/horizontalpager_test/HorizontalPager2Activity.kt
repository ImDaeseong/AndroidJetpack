package com.daeseong.horizontalpager_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daeseong.horizontalpager_test.ui.theme.HorizontalPager_testTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask
import kotlin.math.*
import androidx.compose.ui.unit.IntOffset


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

    Box(modifier = Modifier.fillMaxSize()) {
        val pageCount = list.size
        val start = 0
        val pageState = rememberPagerState(initialPage = start)
        val coroutineState = rememberCoroutineScope()

        DisposableEffect(Unit) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    coroutineState.launch {
                        val nextPage = (pageState.currentPage + 1) % (pageCount * 10)//val nextPage = (pageState.currentPage + 1) % (pageCount * 1000)
                        pageState.animateScrollToPage(nextPage)
                    }
                }
            }, 3000, 3000)
            onDispose {
                timer.cancel()
            }
        }

        HorizontalPager(
            modifier = Modifier.height(300.dp).background(Color.LightGray),
            state = pageState,
            count = pageCount * 10, //count = pageCount * 1000, // 아이템을 반복하도록 count 설정 => list 개수보다만 크면 무한 반복이 가능
            itemSpacing = 10.dp,
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp)
        ) { index ->

            val page = index % pageCount
            println(page)

            Card(modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp))
            {
                Image(
                    painter = painterResource(id = list[page]),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }

        HorizontalPagerIndicator(
            pageCount = pageCount,
            currentPage = calculatePage(pageCount, pageState.currentPage, start),
            indicatorSpacing = 8.dp,
            indicatorSize = 12.dp,
            activeColor = Color.Red,
            inactiveColor = Color.Gray
        )
    }
}

private fun calculatePage(pageCount: Int, index: Int, start: Int): Int {
    val page = (index - start) % pageCount
    return if (page < 0) page + pageCount else page
}

@Composable
fun HorizontalPagerIndicator(
    pageCount: Int,
    currentPage: Int,
    indicatorSpacing: Dp,
    indicatorSize: Dp,
    activeColor: Color,
    inactiveColor: Color)
{
    val density = LocalDensity.current
    val scaledSpacing = with(density) { indicatorSpacing.toPx() }

    Layout(
        content = {
            repeat(pageCount) { index ->
                Surface(
                    modifier = Modifier.size(indicatorSize),
                    color = if (index == currentPage) activeColor else inactiveColor,
                    shape = RoundedCornerShape(percent = 50)
                ) {}
            }
        })
    { measurables, constraints ->

        val indicatorWidth = with(density) { indicatorSize.toPx() }
        val indicatorHeight = with(density) { indicatorSize.toPx() }

        val totalIndicatorWidth = (indicatorWidth * pageCount) + (scaledSpacing * (pageCount - 1))
        val offsetX = ((constraints.maxWidth - totalIndicatorWidth) / 2).coerceAtLeast(0f)

        val itemConstraints = constraints.copy(
            minWidth = indicatorWidth.roundToInt(),
            maxWidth = indicatorWidth.roundToInt(),
            minHeight = indicatorHeight.roundToInt(),
            maxHeight = indicatorHeight.roundToInt()
        )

        val placeables = measurables.map { measurable ->
            measurable.measure(itemConstraints)
        }

        layout(
            width = constraints.maxWidth,
            height = indicatorHeight.roundToInt())
        {
            var xPosition = offsetX
            val yPosition = (indicatorHeight - placeables[0].height) / 2

            placeables.forEachIndexed { index, placeable ->
                placeable.place(IntOffset(x = xPosition.roundToInt(), y = yPosition.roundToInt()))
                xPosition += indicatorWidth + scaledSpacing
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    HorizontalPager_testTheme {
        Test2()
    }
}