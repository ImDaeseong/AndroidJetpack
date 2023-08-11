package com.daeseong.bottomnavigation_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daeseong.bottomnavigation_test.ui.theme.BottomNavigation_testTheme

class BottomMain2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun BottomMenu2(nav : NavHostController) {

    val bottomMenuitems = listOf(
        MenuItem.Home,
        MenuItem.Search,
        MenuItem.Info,
        MenuItem.Settings
    )

    BottomNavigation(modifier = Modifier
        .graphicsLayer {
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            clip = true
        }
        .fillMaxWidth()
        .height(56.dp),
        backgroundColor = Color.Black,
        contentColor = Color.White)
    {
        val currentBack by nav.currentBackStackEntryAsState()
        val currentDestination = currentBack?.destination?.route ?: "Home"

        bottomMenuitems.forEach { item ->

            BottomNavigationItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title, modifier = Modifier.size(20.dp),
                        tint = if (currentDestination == item.title) Color.Red else Color.Black)
                },
                label = { Text(text = item.title) },
                selected = currentDestination ==  item.route,
                onClick = { nav.navigate( item.route) },
                alwaysShowLabel = true,
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Composable
fun Test2() {

    val nav = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomMenu2(nav)
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding))
            {
                TopMenu1(nav)
            }
        },
        backgroundColor = Color.White)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    BottomNavigation_testTheme {
        Test2()
    }
}

sealed class MenuItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : MenuItem("Home", Icons.Default.Home, "Home")
    object Search : MenuItem("Search", Icons.Default.Search, "Search")
    object Info : MenuItem("Info", Icons.Default.Info, "Info")
    object Settings : MenuItem("Settings", Icons.Default.Settings, "Settings")
}