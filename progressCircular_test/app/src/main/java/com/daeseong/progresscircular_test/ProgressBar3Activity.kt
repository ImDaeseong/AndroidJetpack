package com.daeseong.progresscircular_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.progresscircular_test.ui.theme.ProgressCircular_testTheme

class ProgressBar3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressCircular_testTheme {
                progressCircular_test3()
            }
        }
    }
}

@Composable
fun progressCircular_test3() {

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize())
    {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ProgressCircular_testTheme {
        progressCircular_test3()
    }
}