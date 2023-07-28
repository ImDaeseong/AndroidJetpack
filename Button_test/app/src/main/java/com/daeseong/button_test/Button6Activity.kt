package com.daeseong.button_test

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.button_test.ui.theme.Button_testTheme
import kotlinx.coroutines.launch

class Button6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Test6()
            }
        }
    }
}

@Composable
fun ButtonEx(title: String, onClick: () -> Unit) {

    Button(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp),
        onClick = onClick)
    {
        Text(text = title, fontSize = 15.sp, color = Color.White)
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun Test6() {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    ButtonEx("ButtonEx") {
        coroutineScope.launch {
            showToast(context, "click1")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    Button_testTheme {
        Test6()
    }
}