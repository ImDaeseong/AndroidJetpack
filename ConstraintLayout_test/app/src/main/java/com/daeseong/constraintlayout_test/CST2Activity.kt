package com.daeseong.constraintlayout_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.constraintlayout_test.ui.theme.ConstraintLayout_testTheme

class CST2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun Test2() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ConstraintLayout_testTheme {
        Test2()
    }
}