package com.daeseong.qrgooglezxing_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.qrgooglezxing_test.ui.theme.QRgooglezxing_testTheme

class QR1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    QRgooglezxing_testTheme {
        Test1()
    }
}