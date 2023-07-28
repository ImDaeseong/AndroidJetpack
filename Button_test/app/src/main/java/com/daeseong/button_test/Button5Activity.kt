package com.daeseong.button_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.button_test.ui.theme.Button_testTheme

class Button5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test5()
        }
    }
}

@Composable
fun Test5() {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd)
    {
        FloatingActionButton(modifier = Modifier.padding(10.dp),
            backgroundColor = Color.Gray,
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            onClick = {
                Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
            })
        {
            Icon(Icons.Filled.Favorite, tint = Color.Red, contentDescription = "", modifier = Modifier.size(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Button_testTheme {
        Test5()
    }
}