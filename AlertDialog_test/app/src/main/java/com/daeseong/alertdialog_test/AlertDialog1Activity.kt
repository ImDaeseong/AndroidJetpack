package com.daeseong.alertdialog_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.daeseong.alertdialog_test.ui.theme.AlertDialog_testTheme


class AlertDialog1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertDialog_testTheme {
               Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Test1()
                }
            }
        }
    }
}

@Composable
fun AlertDialog1() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button1", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun AlertDialog2() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button2", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color.White,
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun AlertDialog3() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button3", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(
            shape = CircleShape,
            backgroundColor = Color.White,
            contentColor = Color.Red,
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun AlertDialog4() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button4", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(modifier = Modifier
            .width(400.dp)
            .height(150.dp),
            backgroundColor = Color.White,
            contentColor = Color.Red,
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun AlertDialog5() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button5", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(modifier = Modifier
            .fillMaxWidth(),
            backgroundColor = Color.White,
            contentColor = Color.Red,
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            buttons = {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly)
                {
                    TextButton(onClick = { showDialog.value = false }) {
                        Text(text = "dismissButton")
                    }

                    TextButton(onClick = { showDialog.value = false }) {
                        Text(text = "confirmButton")
                    }
                }
            }
        )
    }
}

@Composable
fun AlertDialog6() {

    val showDialog = remember { mutableStateOf(false) }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button6", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(
            properties = DialogProperties(
                dismissOnBackPress = true,// back 버튼 처리로 true 를 주면 back 버튼 누를경우 onDismissRequest 가 호출됨
                dismissOnClickOutside = false,//Dialog 외부 클릭시 처리로 true를 주면  Dialog 외부 클릭시 onDismissRequest 가 호출됨
                securePolicy = SecureFlagPolicy.SecureOn//SecureFlagPolicy.SecureOn 를 대빙하면 화면 캡쳐기능이 동작안함
            ),
            title = {
                Text(text = "제목")
            },
            text = {
                Text(text = "내용")
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun AlertDialog7() {

    val showDialog = remember { mutableStateOf(false) }

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp),
        textAlign = TextAlign.Start,
        text = "입력 내용: ${textState.text}")

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp),
        onClick = { showDialog.value = true },
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(text = "Button7", color = Color.White)
    }

    if (showDialog.value) {

        AlertDialog(
            backgroundColor = Color.White,
            contentColor = Color.Red,
            title = {
                Text(text = "제목")
            },
            text = {
                TextField(
                    value = textState,
                    onValueChange = { newValue ->
                        textState = newValue
                    })
            },
            onDismissRequest = {

            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "dismissButton")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "confirmButton")
                }
            }
        )
    }
}

@Composable
fun Test1() {

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        AlertDialog1()
        AlertDialog2()
        AlertDialog3()
        AlertDialog4()
        AlertDialog5()
        AlertDialog6()
        AlertDialog7()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AlertDialog_testTheme {
        Test1()
    }
}