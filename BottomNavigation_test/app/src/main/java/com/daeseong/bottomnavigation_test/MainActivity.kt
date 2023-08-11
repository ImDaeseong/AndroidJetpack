package com.daeseong.bottomnavigation_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.bottomnavigation_test.ui.theme.BottomNavigation_testTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Splash()
        }
    }
}

@Composable
fun Splash() {

    val context = LocalContext.current

    //한번만 호출위해 LaunchedEffect
    LaunchedEffect(key1 = true){
        delay(3000L)
        //context.startActivity(Intent(context, BottomMain1Activity::class.java))
        //context.startActivity(Intent(context, BottomMain2Activity::class.java))
        //context.startActivity(Intent(context, BottomMain3Activity::class.java))
        context.startActivity(Intent(context, BottomMain4Activity::class.java))
    }

    Column(modifier = Modifier.fillMaxSize().background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(modifier = Modifier.width(200.dp).height(200.dp), painter = painterResource(id = R.drawable.g) , contentDescription = null)

        Text(text = "loading...", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavigation_testTheme {
        Splash()
    }
}