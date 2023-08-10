package com.daeseong.webview_test

import android.graphics.Bitmap
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.daeseong.webview_test.ui.theme.WebView_testTheme

class WebView1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Preview
@Composable
fun CallWeb2() {

    val sUrl : String = "https://m.naver.com"

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)

                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                }

                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }
            settings.javaScriptEnabled = true
            loadUrl(sUrl)
        }
    }, update = {
        it.loadUrl(sUrl)
    })
}

@Preview
@Composable
fun CallWeb1() {

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

@Composable
fun Test1() {
    CallWeb2()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    WebView_testTheme {
        Test1()
    }
}