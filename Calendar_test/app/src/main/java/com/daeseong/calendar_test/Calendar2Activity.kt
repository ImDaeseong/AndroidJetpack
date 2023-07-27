package com.daeseong.calendar_test

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.daeseong.calendar_test.ui.theme.Calendar_testTheme
import java.util.*

class Calendar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2()
        }
    }
}

@Composable
fun Test2() {

    val Cal = Calendar.getInstance()
    val nHour :Int = Cal.get(Calendar.HOUR_OF_DAY)
    val nMinute :Int = Cal.get(Calendar.MINUTE)

    val timeState = remember { mutableStateOf("") }

    val datePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _ , hour : Int, minute : Int ->
            val sData = String.format("%02d:%02d", hour, minute)
            timeState.value = sData
            //timeState.value = "$hour:$minute"
        },
        nHour, nMinute, false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "입력 내용: ${timeState.value}")

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { datePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(Color.Gray))
        {
            Text(text = "Button1", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Calendar_testTheme {
        Test2()
    }
}