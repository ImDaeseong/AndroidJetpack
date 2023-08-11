package com.daeseong.row_test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.row_test.ui.theme.Row_testTheme

class Row5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    Test5()
                }
            }
        }
    }
}

@Composable
fun Test5() {

    val context = LocalContext.current

    Row(modifier = Modifier.fillMaxSize().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly)
    {
        Button(
            onClick = {
                Toast.makeText(context, "click1", Toast.LENGTH_SHORT).show()
            },)
        {
            Icon(imageVector = Icons.Filled.Search,null)
        }

        Button(
            onClick = {
                Toast.makeText(context, "click2", Toast.LENGTH_SHORT).show()
            },)
        {
            Icon(imageVector = Icons.Filled.ArrowBack,null)
        }

        Button(
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
fun DefaultPreview6() {
    Row_testTheme {
        Test5()
    }
}