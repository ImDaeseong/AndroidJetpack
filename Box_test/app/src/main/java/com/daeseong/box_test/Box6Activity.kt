package com.daeseong.box_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.box_test.ui.theme.Box_testTheme

class Box6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Test6()
            }
        }
    }
}

@Composable
fun Test6() {

    Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Gray)
            .padding(10.dp),
        contentAlignment = Alignment.Center)
    {
        Image(
            painter = painterResource(id = R.drawable.a),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            text = "Box image text",
            fontSize = 20.sp,
            color = Color.White
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    Box_testTheme {
        Test6()
    }
}