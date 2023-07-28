package com.daeseong.topappbar_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.topappbar_test.ui.theme.TopAppBar_testTheme

class TopAppBar5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Test5()
            }
        }
    }
}

@Composable
fun Test5() {

    val context = LocalContext.current

    Surface(elevation = 2.dp, color = Color.LightGray) {

        Row(modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Image(
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "Image1", Toast.LENGTH_SHORT).show()
                    },
                painter = painterResource(id = com.daeseong.topappbar_test.R.drawable.play),
                contentDescription = null,
                contentScale = ContentScale.Fit)

            Image(
                painter = painterResource(id = com.daeseong.topappbar_test.R.drawable.play),
                contentDescription = null,
                contentScale = ContentScale.Fit)

            Image(
                painter = painterResource(id = com.daeseong.topappbar_test.R.drawable.play),
                contentDescription = null,
                contentScale = ContentScale.Fit)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    TopAppBar_testTheme {
        Test5()
    }
}