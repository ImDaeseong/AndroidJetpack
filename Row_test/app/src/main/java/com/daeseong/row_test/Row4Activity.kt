package com.daeseong.row_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.row_test.ui.theme.Row_testTheme

class Row4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Test4()
                    }
                }
            }
        }
    }
}

@Composable
fun Test4() {

    val context = LocalContext.current

    Row(modifier = Modifier.fillMaxWidth())
    {
        IconButton(
            onClick = {
                Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
            },)
        {
            Icon(imageVector = Icons.Filled.Search,null)
        }

        IconButton(
            onClick = {
                Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
            },)
        {
            Icon(imageVector = Icons.Filled.ArrowBack,null)
        }

        IconButton(
            onClick = {
                Toast.makeText(context, "click3", Toast.LENGTH_SHORT).show()
            },)
        {
            Icon(imageVector = Icons.Filled.Done,null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Row_testTheme {
        Test4()
    }
}