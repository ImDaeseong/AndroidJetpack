package com.daeseong.navcontroller_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daeseong.navcontroller_test.ui.theme.NavController_testTheme

class NavController1Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    val navController = rememberNavController()

    NavHost(modifier = Modifier.padding(10.dp).background(Color.Gray),
        navController = navController,
        startDestination = "page1")
    {
        composable("page1") {
            Page1Screen(navController)
        }

        composable("page2") {
            Page2Screen(navController)
        }

        composable("page3") {
            Page3Screen(navController)
        }
    }
}

@Composable
fun Page1Screen(navController : NavController) {

    Column(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(modifier = Modifier
            .clickable {
                navController.navigate("page2")
            },
            text = "page1")
    }
}

@Composable
fun Page2Screen(navController : NavController) {

    Column(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(modifier = Modifier
            .clickable {
                navController.navigate("page3")
            },
            text = "page2")
    }
}

@Composable
fun Page3Screen(navController : NavController) {

    Column(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(modifier = Modifier
            .clickable {
                navController.navigate("page1")
            },
            text = "page3")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    NavController_testTheme {
        Test1()
    }
}