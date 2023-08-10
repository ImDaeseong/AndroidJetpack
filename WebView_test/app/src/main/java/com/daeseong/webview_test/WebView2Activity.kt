package com.daeseong.webview_test

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.daeseong.webview_test.ui.theme.WebView_testTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class WebView2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Test2()  {

    val list = listOf("page1", "page2", "page3")

    Column(modifier = Modifier.fillMaxSize())
    {
        val pageState = rememberPagerState()
        val coroutineState = rememberCoroutineScope()

        TabRow(
            selectedTabIndex = pageState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pageState, tabPositions))
            })
        {
            list.forEachIndexed { index, s ->

                Tab(
                    text = { Text(text = s) },
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

@Composable
fun TabScreen1() {

    Column(modifier = Modifier.fillMaxSize())
    {
        val sUrl : String = "https://m.naver.com"

        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(sUrl)
            }
        }, update = {
            it.loadUrl(sUrl)
        })
    }
}

@Composable
fun TabScreen2() {

    Column(modifier = Modifier.fillMaxSize())
    {
        val sUrl : String = "https://m.naver.com"

        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(sUrl)
            }
        }, update = {
            it.loadUrl(sUrl)
        })
    }
}

@Composable
fun TabScreen3() {

    Column(modifier = Modifier.fillMaxSize())
    {
        val sUrl : String = "https://m.naver.com"

        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(sUrl)
            }
        }, update = {
            it.loadUrl(sUrl)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    WebView_testTheme {
        Test2()
    }
}