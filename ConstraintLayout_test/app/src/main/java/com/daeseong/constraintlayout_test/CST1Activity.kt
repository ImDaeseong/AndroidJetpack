package com.daeseong.constraintlayout_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.daeseong.constraintlayout_test.ui.theme.ConstraintLayout_testTheme

class CST1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Test1()
            }

        }
    }
}

@Composable
fun Test1() {

    ConstraintLayout(modifier = Modifier.size(50.dp, 300.dp)) {

        val (Box1, Box2, Box3, Box4) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(Box1)
            {
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(Box2)
            {
                top.linkTo(Box1.bottom, 20.dp)
                start.linkTo(Box1.start)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(Box3)
            {
                top.linkTo(Box2.bottom, 20.dp)
                start.linkTo(Box2.start)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .constrainAs(Box4)
            {
                top.linkTo(Box3.bottom, 20.dp)
                start.linkTo(Box3.start)
            })
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ConstraintLayout_testTheme {
        Test1()
    }
}