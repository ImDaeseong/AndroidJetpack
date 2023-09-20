package com.daeseong.progresscircular_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.progresscircular_test.ui.theme.ProgressCircular_testTheme

class ProgressBar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            progressCircular_test2()
        }
    }
}

@Composable
fun progressCircular_test2() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProgressCircular_testTheme {
        progressCircular_test2()
    }
}