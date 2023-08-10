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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class BottomMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val localActivity = staticCompositionLocalOf<ComponentActivity> {
            error("LocalActivity is not present")
        }

        setContent {

            val nav = rememberNavController()

            Surface()
            {
                Scaffold( bottomBar = { BottomMenu(nav)} )
                {
                    CompositionLocalProvider(localActivity provides this@BottomMainActivity) {
                        TopMenu(nav)
                    }
                }
            }
        }
    }
}

@Composable
fun TopMenu(host: NavHostController) {

    NavHost(navController = host, startDestination = "Home" ){

        composable("Home"){

            Column(modifier = Modifier.fillMaxSize().background(Color.Red)){
            }
        }

        composable("Search"){

            Column(modifier = Modifier.fillMaxSize().background(Color.Blue)){
            }
        }

        composable("Info"){

            Column(modifier = Modifier.fillMaxSize().background(Color.Yellow)){
            }
        }

        composable("Settings"){

            Column(modifier = Modifier.fillMaxSize().background(Color.Green)){
            }
        }
    }

}

@Composable
fun BottomMenu(nav : NavController) {

    val currentBack by nav.currentBackStackEntryAsState()
    val currentDestination = currentBack?.destination?.route ?: "Home"

    BottomNavigation(backgroundColor = Color.White, modifier = Modifier
        .fillMaxWidth()
        .height(56.dp))
    {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, tint = Color.Black, contentDescription = "Home", modifier = Modifier.size(20.dp))
            },
            label = { Text(text = "Home") },
            selected = currentDestination == "Home",
            onClick = { nav.navigate("Home") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Search, tint = Color.Black, contentDescription = "Search", modifier = Modifier.size(20.dp))
            },
            label = { Text(text = "Search") },
            selected = currentDestination == "Search",
            onClick = { nav.navigate("Search") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Info, tint = Color.Black, contentDescription = "Info", modifier = Modifier.size(20.dp))
            },
            label = { Text(text = "Info") },
            selected = currentDestination == "Info",
            onClick = { nav.navigate("Info") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray)

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Settings, tint = Color.Black, contentDescription = "Settings", modifier = Modifier.size(20.dp))
            },
            label = { Text(text = "Settings") },
            selected = currentDestination == "Settings",
            onClick = { nav.navigate("Settings") },
            alwaysShowLabel = true,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color.Gray)
    }
}