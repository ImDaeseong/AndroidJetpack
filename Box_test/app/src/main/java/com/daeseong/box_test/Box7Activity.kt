package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box7Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test7()
        }
    }
}

@Composable
fun Test7() {


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    Box_testTheme {
        Test7()
    }
}