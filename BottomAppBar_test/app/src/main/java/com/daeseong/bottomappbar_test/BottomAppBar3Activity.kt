package com.daeseong.bottomappbar_test

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.bottomappbar_test.ui.theme.BottomAppBar_testTheme

class BottomAppBar3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Test3()
                }
            }
        }
    }
}

@Composable
private fun ButtonIconEx(context : Context, icon : ImageVector) {

    IconButton(
        onClick = {
            Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
        })
    {
        Icon(icon, contentDescription = "")
    }
}

@Composable
fun Test3() {

    val context = LocalContext.current

    BottomAppBar(backgroundColor = Color.Gray) {

        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceAround)
        {
            ButtonIconEx(context, Icons.Filled.Favorite)
            ButtonIconEx(context, Icons.Filled.Email)
            ButtonIconEx(context, Icons.Filled.Search)
            ButtonIconEx(context, Icons.Filled.Menu)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    BottomAppBar_testTheme {
        Test3()
    }
}