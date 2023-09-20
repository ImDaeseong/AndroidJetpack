package com.daeseong.progresscircular_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.progresscircular_test.ui.theme.ProgressCircular_testTheme

class ProgressBar1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressCircular_testTheme {
                progressCircular_test1()
            }
        }
    }
}


@Composable
fun progressCircular_test1() {



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ProgressCircular_testTheme {
        progressCircular_test1()
    }
}