package com.daeseong.textfield_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.textfield_test.ui.theme.TextField_testTheme

class TextField3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@Composable
fun Test3() {

    val sStr = remember { mutableStateOf(TextFieldValue("")) }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            TextFieldEx(sStr)

            Spacer(modifier = Modifier.height(10.dp))

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
                textAlign = TextAlign.Start,
                text = "입력 내용: ${sStr.value.text}")
        }
    }
}

@Composable
fun TextFieldEx(input: MutableState<TextFieldValue>) {

    TextField(modifier = Modifier.fillMaxWidth(),
        value = input.value,
        onValueChange = {
            input.value = it
        },
        placeholder = { Text("placeholder") })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    TextField_testTheme {
        Test3()
    }
}