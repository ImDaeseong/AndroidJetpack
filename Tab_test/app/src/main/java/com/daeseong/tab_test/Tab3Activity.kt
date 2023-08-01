package com.daeseong.tab_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.tab_test.ui.theme.Tab_testTheme

class Tab3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@Composable
fun Test3() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Tab_testTheme {
        Test3()
    }
}