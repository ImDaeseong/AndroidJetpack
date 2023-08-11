package com.daeseong.bottomnavigation_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.daeseong.bottomnavigation_test.ui.theme.BottomNavigation_testTheme

class BottomMain3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@Composable
fun Test3() {

    val context = LocalContext.current

    val nav = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("메뉴") },
                navigationIcon = {
                    IconButton(onClick = { Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show() })
                    {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = { BottomMenu2(nav) })
    {
        TopMenu1(nav)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    BottomNavigation_testTheme {
        Test3()
    }
}