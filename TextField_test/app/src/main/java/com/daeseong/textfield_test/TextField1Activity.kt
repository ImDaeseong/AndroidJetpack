package com.daeseong.textfield_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.textfield_test.ui.theme.TextField_testTheme

class TextField1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextField_testTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Test1()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TextField1()  {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp),
        textAlign = TextAlign.Start,
        text = "입력 내용: ${textState.text}")

    TextField(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        value = textState,
        onValueChange = { newValue ->
            textState = newValue
        },
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        maxLines = 1,
        label = { Text(text = "Input ID") },
        placeholder = { Text(text = "ID") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = Color.Gray,
            cursorColor = Color.Red,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview
@Composable
fun TextField2()  {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp),
        textAlign = TextAlign.Start,
        text = "입력 내용: ${textState.text}")

    TextField( modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .border(width = 1.dp, color = Color.Red),
        value = textState,
        onValueChange = { textState = it },
        singleLine = true,
        maxLines = 1,
        placeholder = { Text(text = "아이디") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = Color.Gray,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.White
        )
    )
}

@Preview
@Composable
fun TextField3()  {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp),
        textAlign = TextAlign.Start,
        text = "입력 내용: ${textState.text}")

    TextField( modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        value = textState,
        onValueChange = { textState = it },
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(5.dp),
        label = { Text("입력하세요") },
        placeholder = { Text(text = "아이디") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = Color.Gray,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.White
        )
    )
}

@Preview
@Composable
fun TextField4()  {

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp),
        textAlign = TextAlign.Start,
        text = "입력 내용: ${textState.text}")

    BasicTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp)
        .padding(end = 10.dp)
        .border(width = 1.dp, color = Color.Red)
        .height(50.dp),
        value = textState,
        onValueChange = { textState = it },
        singleLine = true,
        maxLines = 1,
        textStyle = androidx.compose.ui.text.TextStyle(
            color = Color.Red,
            fontSize = 15.sp,
            background = Color.White
        ),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier
                .padding(10.dp),
                contentAlignment = Alignment.CenterStart)
            {
                innerTextField()
            }
        }
    )
}

@Composable
fun Test1()  {

    TextField1()

    Spacer(Modifier.height(10.dp))

    TextField2()

    Spacer(Modifier.height(10.dp))

    TextField3()

    Spacer(Modifier.height(10.dp))

    TextField4()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Test1()
}