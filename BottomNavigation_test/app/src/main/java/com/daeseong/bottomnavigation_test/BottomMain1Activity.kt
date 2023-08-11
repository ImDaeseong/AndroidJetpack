package com.daeseong.bottomnavigation_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daeseong.bottomnavigation_test.ui.theme.BottomNavigation_testTheme

class BottomMain1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Test1()
        }
    }
}

@Composable
fun TopMenu1(host: NavHostController) {

    NavHost(navController = host, startDestination = "Home" )
    {
        composable("Home"){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)){
            }
        }

        composable("Search"){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)){
            }
        }

        composable("Info"){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)){
            }
        }

        composable("Settings"){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)){
            }
        }
    }
}

@Composable
fun BottomMenu1(nav : NavHostController) {

    val currentBack by nav.currentBackStackEntryAsState()
    val currentDestination = currentBack?.destination?.route ?: "Home"

    BottomNavigation(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        backgroundColor = Color.White,
        contentColor = Color.White)
    {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(20.dp),
                    tint = if (currentDestination == "Home") Color.Red else Color.Black)
            },
            label = { Text(text = "Home") },
            selected = currentDestination == "Home",
            onClick = { nav.navigate("Home") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search", modifier = Modifier.size(20.dp),
                    tint = if (currentDestination == "Search") Color.Red else Color.Black)
            },
            label = { Text(text = "Search") },
            selected = currentDestination == "Search",
            onClick = { nav.navigate("Search") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Info", modifier = Modifier.size(20.dp),
                    tint = if (currentDestination == "Info") Color.Red else Color.Black)
            },
            label = { Text(text = "Info") },
            selected = currentDestination == "Info",
            onClick = { nav.navigate("Info") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", modifier = Modifier.size(20.dp),
                    tint = if (currentDestination == "Settings") Color.Red else Color.Black)
            },
            label = { Text(text = "Settings") },
            selected = currentDestination == "Settings",
            onClick = { nav.navigate("Settings") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.Gray)
    }
}

@Composable
fun Test1() {

    val nav = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomMenu1(nav)
        })
    {
        //바깥쪽 Box 크기에 맞게 자동 설정
        Box(Modifier.padding(it)) {
            TopMenu1(nav)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    BottomNavigation_testTheme {
        Test1()
    }
}