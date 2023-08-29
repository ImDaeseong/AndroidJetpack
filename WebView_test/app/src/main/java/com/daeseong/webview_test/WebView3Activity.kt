package com.daeseong.webview_test

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.*
import android.webkit.WebSettings.LOAD_NO_CACHE
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

class WebView3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CallWeb3() {

    val sUrl : String = "https://m.naver.com"

    val context = LocalContext.current
    val webView = rememberUpdatedState(WebView(context))

    AndroidView(
        factory = { webView.value },
        modifier = Modifier.fillMaxSize() ) { view ->

        view.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            }
        }

        view.webChromeClient = object : WebChromeClient() {

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)

                if (newProgress == 100) {
                    println(newProgress)
                } else {
                    println(newProgress)
                }
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                //println(title)
            }

        }

        view.settings.javaScriptEnabled = true
        view.settings.cacheMode = LOAD_NO_CACHE
        view.loadUrl(sUrl)
    }
}

@Preview(showBackground = true)
@Composable
fun Test3() {
    CallWeb3()
}