package com.daeseong.tab_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.tab_test.ui.theme.Tab_testTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class Tab2Activity : ComponentActivity() {
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

    val list = listOf("page1", "page2", "page3")

    Column(modifier = Modifier.fillMaxSize())
    {
        val pageState = rememberPagerState()
        val coroutineState = rememberCoroutineScope()

        TabRow(
            backgroundColor = Color.White,
            contentColor = Color.Red,
            divider = {
                TabRowDefaults.Divider(thickness = 2.dp, color = Color.LightGray)
            },
            selectedTabIndex = pageState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pageState, tabPositions),
                    height = 1.dp,
                    color = Color.Red
                )
            })
        {
            list.forEachIndexed { index, s ->

                Tab(
                    text = {
                        Text(
                            text = s,
                            color =  if (pageState.currentPage == index) Color.Red else Color.Black
                        )
                    },
                    icon  = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                    },
                    selected = pageState.currentPage == index,
                    onClick = {
                        coroutineState.launch {
                            pageState.scrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(count = list.size, state = pageState) { page ->

            when(page) {
                0 -> TabScreen1()
                1 -> TabScreen2()
                2 -> TabScreen3()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Tab_testTheme {
        Test2()
    }
}