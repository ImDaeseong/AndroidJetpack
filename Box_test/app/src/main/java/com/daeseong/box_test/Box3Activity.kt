package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box_testTheme {
                Test3()
            }
        }
    }
}

@Composable
fun Test3() {

    Box(modifier = Modifier.background(Color.Gray).fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.Center)
    {
        Column(modifier = Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp))
        {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Red, CircleShape))

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Green, RoundedCornerShape(8.dp)))

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Box_testTheme {
        Test3()
    }
}