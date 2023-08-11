package com.daeseong.topappbar_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test6()
        }
    }
}

@Composable
fun Test6() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    TopAppBar_testTheme {
        Test6()
    }
}