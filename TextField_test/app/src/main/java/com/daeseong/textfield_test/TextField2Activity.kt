package com.daeseong.textfield_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.textfield_test.ui.theme.TextField_testTheme

class TextField2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Test2()
            }
        }
    }
}

@Composable
fun TextString() {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Surface(modifier = Modifier.padding(10.dp), color = Color.LightGray)
    {
        TextField(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            value = textState,
            onValueChange = {
                textState = it
            } )
    }
}

@Composable
fun TextNumber() {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Surface(modifier = Modifier.padding(10.dp), color = Color.LightGray) {

        TextField(modifier = Modifier.padding(10.dp).fillMaxWidth(),

            value = textState,
            onValueChange = {
                val newText = it.text.filter { char -> char.isDigit() }
                textState = it.copy(text = newText)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
            })
        )
    }
}

@Composable
fun TextPassword() {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Surface(modifier = Modifier.padding(10.dp), color = Color.LightGray) {

        TextField(modifier = Modifier.padding(10.dp).fillMaxWidth(),

            value = textState,
            onValueChange = {
                textState = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {

            })
        )
    }
}

@Composable
fun Test2() {

    TextString()
    TextNumber()
    TextPassword()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TextField_testTheme {
        Test2()
    }
}