package com.daeseong.tab_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.tab_test.ui.theme.Tab_testTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class Tab3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Test3() {

    val list = listOf(
        ImgTabItem(
            text = "page1",
            icon = Icons.Filled.Face,
            screen = {
                TabScreen1()
            }
        ),
        ImgTabItem(
            text = "page2",
            icon = Icons.Filled.Favorite,
            screen = {
                TabScreen2()
            }
        ),
        ImgTabItem(
            text = "page3",
            icon = Icons.Filled.Refresh,
            screen = {
                TabScreen3()
            }
        )
    )

    val pageState = rememberPagerState()
    val coroutineState = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize())
    {
        TabRow(selectedTabIndex = pageState.currentPage)
        {
            list.forEachIndexed { index, item ->

                Tab(
                    text = {
                        Text(text = item.text)
                    },
                    icon = {
                        Icon(imageVector = item.icon, "")
                    },
                    selected = pageState.currentPage == index,
                    onClick = {
                        coroutineState.launch{
                            pageState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(count = list.size, state = pageState) 
        {
            list[pageState.currentPage].screen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Tab_testTheme {
        Test3()
    }
}

data class ImgTabItem(
    val text : String,
    val icon : ImageVector,
    val screen : @Composable () -> Unit
)