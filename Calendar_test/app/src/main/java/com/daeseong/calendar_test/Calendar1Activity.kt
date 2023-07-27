package com.daeseong.calendar_test

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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

class Calendar1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    val Cal = Calendar.getInstance()
    val nYear :Int = Cal.get(Calendar.YEAR)
    val nMonth :Int = Cal.get(Calendar.MONTH)
    val nDay :Int = Cal.get(Calendar.DAY_OF_MONTH)

    Cal.time = Date()

    val dateState = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _ : DatePicker, year : Int, month : Int, day : Int ->
            val sData = String.format("%04d/%02d/%02d", year, month+1, day)
            dateState.value = sData
            //dateState.value = "$year/${month+1}/$day"
        },
        nYear, nMonth, nDay
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "입력 내용: ${dateState.value}")

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
fun DefaultPreview2() {
    Calendar_testTheme {
        Test1()
    }
}