package com.daeseong.column_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class Column5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test5()
        }
    }
}

@Composable
fun Test5() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Test5()
}